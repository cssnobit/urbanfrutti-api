package com.urbanfrutti.urbanfrutti.api.exceptionhandler;

public enum ProblemType {

	ERRO_NEGOCIO("Erro de negócio"),
	ERRO_ENTIDADE_NAO_ENCONTRADA("Entidade não encontrada"),
	ERRO_ARGUMENTO_INVALIDO("Argumento inválido"),
	ERRO_ENTIDADE_EM_USO("Entidade em uso");
	
	private String title;
	
	ProblemType(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}
	
}
