package com.urbanfrutti.urbanfrutti.domain.exception;

public class PedidoNaoEncontradoException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	public PedidoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public PedidoNaoEncontradoException(Long pedidoId) {
		super(String.format("Não foi possível encontrar o pedido com o id %d", pedidoId));
	}
}
