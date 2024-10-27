package com.urbanfrutti.urbanfrutti.domain.exception;

public class ProdutoNaoEncontradoException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	public ProdutoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public ProdutoNaoEncontradoException(Long produtoId) {
		super(String.format("Não foi possível encontrar o produto com o id %d", produtoId));
	}
}
