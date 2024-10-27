package com.urbanfrutti.urbanfrutti.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.urbanfrutti.urbanfrutti.domain.entity.Usuario;
import com.urbanfrutti.urbanfrutti.domain.exception.EntidadeNaoEncontradaException;
import com.urbanfrutti.urbanfrutti.domain.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	private final String MENSAGEM_USUARIO_NAO_ENCONTRADO = 
			"Não foi possível encontrar o usuario com o id %d";

	public Usuario getUsuario(Long usuarioId) {
		return usuarioRepository.findById(usuarioId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException(String
						.format(MENSAGEM_USUARIO_NAO_ENCONTRADO, usuarioId)));
	}
}
