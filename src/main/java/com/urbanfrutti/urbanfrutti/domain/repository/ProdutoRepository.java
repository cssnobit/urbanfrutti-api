package com.urbanfrutti.urbanfrutti.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.urbanfrutti.urbanfrutti.domain.entity.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	List<Produto> findByNomeIgnoreCaseContaining(String nome);
}
