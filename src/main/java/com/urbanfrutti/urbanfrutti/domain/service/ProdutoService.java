package com.urbanfrutti.urbanfrutti.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.urbanfrutti.urbanfrutti.domain.entity.Produto;
import com.urbanfrutti.urbanfrutti.domain.exception.EntidadeNaoEncontradaException;
import com.urbanfrutti.urbanfrutti.domain.exception.NegocioException;
import com.urbanfrutti.urbanfrutti.domain.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	private final String MENSAGEM_PRODUTO_NAO_ENCONTRADO = 
			"Não foi possível encontrar o produto com o id %d";
	
	public List<Produto> findAll() {
		return produtoRepository.findAll();
		
	}
	
	public Produto save(Produto request) {
		if(request.getPreco().doubleValue() <= 0) {
			throw new NegocioException("Preço não pode ser igual ou menor que zero");
		}
		
		if(request.getQtdEstoque() < 0) {
			throw new NegocioException("Estoque não pode ser igual ou menor que zero");
		}
		return produtoRepository.save(request);

	}
	
	public Produto getProduto(Long produtoId) {
		return produtoRepository.findById(produtoId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException(String
						.format(MENSAGEM_PRODUTO_NAO_ENCONTRADO, produtoId)));
	}
	
	public void remove(Long produtoId) {
		Produto produto = getProduto(produtoId);
		produtoRepository.delete(produto);
	}
	
	public List<Produto> getProdutosByNome(String nome) {
		if(nome.isBlank()) {
			return findAll();
		}
		return produtoRepository.findByNomeIgnoreCaseContaining(nome);
	}
}
