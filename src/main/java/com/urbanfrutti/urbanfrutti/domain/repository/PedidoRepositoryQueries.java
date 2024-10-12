package com.urbanfrutti.urbanfrutti.domain.repository;

import java.util.List;

import com.urbanfrutti.urbanfrutti.domain.entity.Pedido;

public interface PedidoRepositoryQueries {
	
	List<Pedido> getPedidosByUserId(Long usuarioId);

}
