package com.urbanfrutti.urbanfrutti.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.urbanfrutti.urbanfrutti.domain.dto.UserPedidoListResponseDTO;
import com.urbanfrutti.urbanfrutti.domain.entity.Pedido;
import com.urbanfrutti.urbanfrutti.domain.entity.Usuario;
import com.urbanfrutti.urbanfrutti.domain.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private UsuarioService usuarioService;
	
	public Pedido getPedido(Long pedidoId) {
		return pedidoRepository.findById(pedidoId)
				.orElseThrow(() -> new RuntimeException());
	}
	
	public List<UserPedidoListResponseDTO> getAllPedidosByUserId(Long usuarioId) {
		Usuario cliente = usuarioService.getUsuario(usuarioId);
		List<Pedido> pedidos = pedidoRepository.getPedidosByUserId(usuarioId);
		
		return pedidos.stream()
				.map(UserPedidoListResponseDTO::new)
				.collect(Collectors.toList());
	}
}
