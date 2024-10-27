package com.urbanfrutti.urbanfrutti.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.urbanfrutti.urbanfrutti.domain.entity.Produto;
import com.urbanfrutti.urbanfrutti.domain.exception.EntidadeEmUsoException;
import com.urbanfrutti.urbanfrutti.domain.exception.NegocioException;
import com.urbanfrutti.urbanfrutti.domain.exception.ProdutoNaoEncontradoException;
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
			throw new IllegalArgumentException("Preço não pode ser igual ou menor que zero");
		}
		
		if(request.getQtdEstoque() < 0) {
			throw new IllegalArgumentException("Estoque não pode ser igual ou menor que zero");
		}
		return produtoRepository.save(request);

	}
	
	public Produto getProduto(Long produtoId) {
		return produtoRepository.findById(produtoId)
				.orElseThrow(() -> new ProdutoNaoEncontradoException(produtoId));
	}
	
	public void remove(Long produtoId) {
		try {			
			Produto produto = getProduto(produtoId);
			produtoRepository.delete(produto);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException();
		}
	}
	
	public List<Produto> getProdutosByNome(String nome) {
		if(nome.isBlank()) {
			return findAll();
		}
		return produtoRepository.findByNomeIgnoreCaseContaining(nome);
	}
}
