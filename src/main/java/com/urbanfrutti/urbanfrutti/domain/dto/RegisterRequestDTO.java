package com.urbanfrutti.urbanfrutti.domain.dto;

public record RegisterRequestDTO(String email, String nomeCompleto, 
		String cpf, String senha, String celular) {

}
