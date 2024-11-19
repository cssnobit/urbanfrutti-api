package com.urbanfrutti.urbanfrutti.domain.exception;

public class UsuarioNaoEncontradoException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	public UsuarioNaoEncontradoException() {
		super("Usuário não encontrado");
	}
	
	public UsuarioNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public UsuarioNaoEncontradoException(Long userId) {
		super(String.format("Não foi possível encontrar o usuario com o id %d", userId));
	}
}
