package com.urbanfrutti.urbanfrutti.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.urbanfrutti.urbanfrutti.domain.entity.Pedido;
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
	public List<Pedido> getAllPedidosByUserId(@PathVariable Long usuarioId) {
		return pedidoService.getAllPedidosByUserId(usuarioId);
	}
	
}
