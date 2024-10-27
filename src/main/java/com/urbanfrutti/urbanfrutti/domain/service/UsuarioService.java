package com.urbanfrutti.urbanfrutti.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.urbanfrutti.urbanfrutti.domain.entity.Usuario;
import com.urbanfrutti.urbanfrutti.domain.exception.UsuarioNaoEncontradoException;
import com.urbanfrutti.urbanfrutti.domain.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Usuario getUsuario(Long usuarioId) {
		return usuarioRepository.findById(usuarioId)
				.orElseThrow(() -> new UsuarioNaoEncontradoException(usuarioId));
	}
}
