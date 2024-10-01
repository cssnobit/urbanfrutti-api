package com.urbanfrutti.urbanfrutti.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.urbanfrutti.urbanfrutti.domain.entity.Produto;
import com.urbanfrutti.urbanfrutti.domain.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List<Produto> findAll() {
		return produtoRepository.findAll();
		
	}
	
	public Produto save(Produto request) {
		if(request.getPreco().doubleValue() <= 0) {
			throw new RuntimeException();
		}
		
		if(request.getQtdEstoque() < 0) {
			throw new RuntimeException();
		}
		return produtoRepository.save(request);

	}
	
	public Produto getProduto(Long produtoId) {
		return produtoRepository.findById(produtoId)
				.orElseThrow(() -> new RuntimeException());
	}
	
	public void remove(Long produtoId) {
		Produto produto = getProduto(produtoId);
		produtoRepository.delete(produto);
	}
}
