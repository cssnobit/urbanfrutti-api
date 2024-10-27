package com.urbanfrutti.urbanfrutti.domain.exception;

public class EntidadeEmUsoException extends NegocioException {

	private static final long serialVersionUID = 1L;

	public EntidadeEmUsoException(String mensagem) {
		super(mensagem);
	}
	
	public EntidadeEmUsoException() {
		super("Não foi possível removê-la, pois a entidade está em uso");
	}
}
