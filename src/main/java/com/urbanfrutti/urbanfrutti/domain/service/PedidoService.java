package com.urbanfrutti.urbanfrutti.domain.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.urbanfrutti.urbanfrutti.domain.dto.UserPedidoListResponseDTO;
import com.urbanfrutti.urbanfrutti.domain.entity.ItemPedido;
import com.urbanfrutti.urbanfrutti.domain.entity.Pedido;
import com.urbanfrutti.urbanfrutti.domain.entity.Produto;
import com.urbanfrutti.urbanfrutti.domain.entity.Usuario;
import com.urbanfrutti.urbanfrutti.domain.entity.enums.StatusPedido;
import com.urbanfrutti.urbanfrutti.domain.exception.PedidoNaoEncontradoException;
import com.urbanfrutti.urbanfrutti.domain.repository.ItemPedidoRepository;
import com.urbanfrutti.urbanfrutti.domain.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ProdutoService produtoService;
	
	public Pedido getPedido(Long pedidoId) {
		return pedidoRepository.findById(pedidoId)
				.orElseThrow(() -> new PedidoNaoEncontradoException(pedidoId));
	}
	
	public Pedido savePedido(Pedido pedido) {
		double total = 0;
		double subtotal = 0;
		
		for (ItemPedido itemPedido : pedido.getItens()) {
			Produto produto = produtoService.getProduto(itemPedido.getProduto().getId());
			if(produto.getQtdEstoque() < itemPedido.getQtdProduto()) {
				throw new IllegalArgumentException("Quantidade de produto exigida é maior do que"
						+ " existe no estoque");
			}
			produto.setQtdEstoque(produto.getQtdEstoque() - itemPedido.getQtdProduto());
			subtotal = itemPedido.getQtdProduto() * produto.getPreco().doubleValue();
			itemPedido.setSubtotal(new BigDecimal(subtotal));
			total += subtotal;
		}
		
		if(pedido.getStatus() == null) {			
			pedido.setStatus(StatusPedido.CRIADO);
		}
		pedido.setTotal(new BigDecimal(total));
		
		LocalDateTime now = LocalDateTime.now();
		if(pedido.getDataCriacao() == null) {
			pedido.setDataCriacao(now);
			pedido.setDataAtualizacao(now);
		} else {
			pedido.setDataAtualizacao(now);
		}
	
		return linkOrderItem(pedidoRepository.save(pedido).getId());
	}
	
	private Pedido linkOrderItem(Long pedidoId) {
		Pedido pedido = getPedido(pedidoId);
		List<ItemPedido> itens = new ArrayList<>();
		for (ItemPedido itemPedido : pedido.getItens()) {
			itemPedido.setPedido(pedido);
			itens.add(itemPedidoRepository.save(itemPedido));
		}
		
		pedido.setItens(itens);
		return pedido;
	}
	
	public List<UserPedidoListResponseDTO> getAllPedidosByUserId(Long usuarioId) {
		Usuario cliente = usuarioService.getUsuario(usuarioId);
		List<Pedido> pedidos = pedidoRepository.getPedidosByUserId(usuarioId);
		
		return pedidos.stream()
				.map(UserPedidoListResponseDTO::new)
				.collect(Collectors.toList());
	}
}
