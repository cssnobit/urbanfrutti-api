package com.urbanfrutti.urbanfrutti.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.urbanfrutti.urbanfrutti.domain.dto.UserPedidoListResponseDTO;
import com.urbanfrutti.urbanfrutti.domain.entity.Pedido;
import com.urbanfrutti.urbanfrutti.domain.exception.NegocioException;
import com.urbanfrutti.urbanfrutti.domain.exception.ProdutoNaoEncontradoException;
import com.urbanfrutti.urbanfrutti.domain.exception.UsuarioNaoEncontradoException;
import com.urbanfrutti.urbanfrutti.domain.service.PedidoService;

/*
 * 	Controller de Pedidos
 * 
 * */

@RequestMapping("/pedidos")
@RestController
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;
	
	@GetMapping("/clientes/{usuarioId}")
	public List<UserPedidoListResponseDTO> getAllPedidosByUserId(@PathVariable Long usuarioId) {
		try {			
			return pedidoService.getAllPedidosByUserId(usuarioId);
		} catch(UsuarioNaoEncontradoException e) {
			throw new NegocioException(e.getMessage());
		}
	}
	
	@GetMapping("/{pedidoId}")
	public Pedido getPedido(@PathVariable Long pedidoId) {
		return pedidoService.getPedido(pedidoId);
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public Pedido addPedido(@RequestBody Pedido pedido) {
		try {			
			return pedidoService.savePedido(pedido);
		} catch(ProdutoNaoEncontradoException e) {
			throw new NegocioException(e.getMessage());
		} catch(IllegalArgumentException e) {
			throw new IllegalArgumentException(e.getMessage());
		}
	}
}
