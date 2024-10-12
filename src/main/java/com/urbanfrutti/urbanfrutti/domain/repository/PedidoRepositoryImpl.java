package com.urbanfrutti.urbanfrutti.domain.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.urbanfrutti.urbanfrutti.domain.entity.Pedido;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class PedidoRepositoryImpl implements PedidoRepositoryQueries {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Pedido> getPedidosByUserId(Long usuarioId) {
		var jpql = "from Pedido p join Usuario cl on cl.id = p.cliente.id "
				+ "where cl.id = :usuarioId";
		
		return em.createQuery(jpql, Pedido.class)
				.setParameter("usuarioId", usuarioId)
				.getResultList();
	}
	
}
