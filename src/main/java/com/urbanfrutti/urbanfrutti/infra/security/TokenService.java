package com.urbanfrutti.urbanfrutti.infra.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.urbanfrutti.urbanfrutti.domain.entity.Usuario;

@Service
public class TokenService {
	
	@Value("${api.security.token.secret}")
	private String secret;

	public String geraToken(Usuario usuario) {
		try {
			Algorithm algoritmo = Algorithm.HMAC256(secret);
			String token = JWT.create()
					.withIssuer("login-auth-api")
					.withSubject(usuario.getEmail())
					.withExpiresAt(this.geraDataExpiracao())
					.sign(algoritmo);
			
			return token;
					
		} catch(JWTCreationException e) {
			throw new RuntimeException("Ocorreu um erro durante a autenticação");
		}
	}
	
	public String validaToken(String token) {
		try {
			Algorithm algoritmo = Algorithm.HMAC256(secret);
			
			return JWT.require(algoritmo)
					.withIssuer("login-auth-api")
					.build()
					.verify(token)
					.getSubject();
		} catch(JWTVerificationException e) {
			return null;
		}
	}
	
	private Instant geraDataExpiracao() {
		return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-3"));
	}
}
