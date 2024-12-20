package com.urbanfrutti.urbanfrutti.api.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.urbanfrutti.urbanfrutti.domain.entity.Produto;
import com.urbanfrutti.urbanfrutti.domain.exception.EntidadeEmUsoException;
import com.urbanfrutti.urbanfrutti.domain.exception.NegocioException;
import com.urbanfrutti.urbanfrutti.domain.service.ProdutoService;

/*
 * Controller de Produtos
 * 
 * */

@RequestMapping("/produtos")
@RestController
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping
	public List<Produto> findAll() {
		return produtoService.findAll();
	}
	
	@GetMapping("/{produtoId}")
	public Produto getProduto(@PathVariable Long produtoId) {
		return produtoService.getProduto(produtoId);
	}
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping
	public Produto addProduto(@RequestBody Produto request) {
		try {			
			return produtoService.save(request);
		} catch(IllegalArgumentException e) {
			throw new NegocioException(e.getMessage());
		}
	}
	
	@PutMapping("/{produtoId}")
	public Produto updateProduto(@PathVariable Long produtoId, @RequestBody Produto request) {
		try {			
			Produto produtoAtual = produtoService.getProduto(produtoId);
			
			BeanUtils.copyProperties(request, produtoAtual, "id");
			
			return produtoService.save(produtoAtual);
		} catch(IllegalArgumentException e) {
			throw new IllegalArgumentException(e.getMessage());
		}
	}
	
	@GetMapping("/search")
	public List<Produto> getProdutoByNome(@RequestParam String nome) {
		return produtoService.getProdutosByNome(nome);
	}
	
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("/{produtoId}")
	public void removeProduto(@PathVariable Long produtoId) {
		try {			
			produtoService.remove(produtoId);
		} catch(EntidadeEmUsoException e) {
			throw new EntidadeEmUsoException(e.getMessage());
		}
	}
}
