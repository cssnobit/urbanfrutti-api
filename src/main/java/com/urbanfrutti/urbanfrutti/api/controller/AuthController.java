package com.urbanfrutti.urbanfrutti.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.urbanfrutti.urbanfrutti.domain.dto.LoginRequestDTO;
import com.urbanfrutti.urbanfrutti.domain.dto.RegisterRequestDTO;
import com.urbanfrutti.urbanfrutti.domain.dto.ResponseDTO;
import com.urbanfrutti.urbanfrutti.domain.entity.Usuario;
import com.urbanfrutti.urbanfrutti.domain.exception.UsuarioNaoEncontradoException;
import com.urbanfrutti.urbanfrutti.domain.repository.UsuarioRepository;
import com.urbanfrutti.urbanfrutti.infra.security.TokenService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
    private UsuarioRepository repository;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO body){
        Usuario user = this.repository.findByEmail(body.email()).orElseThrow(() -> new UsuarioNaoEncontradoException());
        if(passwordEncoder.matches(body.senha(), user.getSenha())) {
            String token = this.tokenService.geraToken(user);
            return ResponseEntity.ok(new ResponseDTO(user.getId(), 
            		user.getCpf(), user.getNomeCompleto(), user.getEmail(), user.getCelular(),
            		token));
        }
        return ResponseEntity.badRequest().build();
    }


    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterRequestDTO body){
        Optional<Usuario> userEncontrado = this.repository.findByEmail(body.email());

        if(userEncontrado.isEmpty()) {
            Usuario novoUsuario = new Usuario();
            novoUsuario.setSenha(passwordEncoder.encode(body.senha()));
            novoUsuario.setEmail(body.email());
            novoUsuario.setNomeCompleto(body.nomeCompleto());
            novoUsuario.setCpf(body.cpf());
            novoUsuario.setCelular(body.celular());
            Usuario user = this.repository.save(novoUsuario);

            String token = this.tokenService.geraToken(novoUsuario);
            return ResponseEntity.ok(new ResponseDTO(user.getId(), 
            		user.getCpf(), user.getNomeCompleto(), user.getEmail(), user.getCelular(),
            		token));
        }
        return ResponseEntity.badRequest().build();
    }
}
