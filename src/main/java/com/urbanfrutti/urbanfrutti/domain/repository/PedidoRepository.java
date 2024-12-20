package com.urbanfrutti.urbanfrutti.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.urbanfrutti.urbanfrutti.domain.entity.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>, PedidoRepositoryQueries {

}
