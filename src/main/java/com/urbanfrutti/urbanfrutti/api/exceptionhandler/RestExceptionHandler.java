package com.urbanfrutti.urbanfrutti.api.exceptionhandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.urbanfrutti.urbanfrutti.domain.exception.EntidadeEmUsoException;
import com.urbanfrutti.urbanfrutti.domain.exception.EntidadeNaoEncontradaException;
import com.urbanfrutti.urbanfrutti.domain.exception.NegocioException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	private LocalDateTime localDateTime;
	
	private ProblemBody makeProblemBody(HttpStatus status, ProblemType problemType, String message) {		
		return new ProblemBody(status.value(), problemType.getTitle(), message);
	}
	
	@ExceptionHandler(EntidadeNaoEncontradaException.class)
	public ResponseEntity<?> handleEntidadeNaoEncontradaException(
			EntidadeNaoEncontradaException ex, WebRequest request) {
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		ProblemType problemType = ProblemType.ERRO_ENTIDADE_NAO_ENCONTRADA;
		String mensagem = ex.getMessage();
		
		ProblemBody problem = makeProblemBody(status, problemType, mensagem);
		
		return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
	}
	
	@ExceptionHandler(EntidadeEmUsoException.class)
	public ResponseEntity<?> handleEntidadeEmUsoException(
			EntidadeEmUsoException ex, WebRequest request){
		
		HttpStatus status = HttpStatus.CONFLICT;
		ProblemType problemType = ProblemType.ERRO_ENTIDADE_EM_USO;
		String mensagem = ex.getMessage();
		
		ProblemBody problem = makeProblemBody(status, problemType, mensagem);
		
		return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<?> handleIllegalArgumentException(
			IllegalArgumentException ex, WebRequest request) {
		
		HttpStatus status = HttpStatus.BAD_REQUEST;
		ProblemType problemType = ProblemType.ERRO_NEGOCIO;
		String mensagem = ex.getMessage();
		
		ProblemBody problem = makeProblemBody(status, problemType, mensagem);
		
		return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
	}
	
	@ExceptionHandler(NegocioException.class)
	public ResponseEntity<?> handleNegocioException(
			NegocioException ex, WebRequest request) {
		
		HttpStatus status = HttpStatus.BAD_REQUEST;
		ProblemType problemType = ProblemType.ERRO_NEGOCIO;
		String mensagem = ex.getMessage();
		
		ProblemBody problem = makeProblemBody(status, problemType, mensagem);
		
		return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleUncaught(
			Exception ex, WebRequest request) {
		
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		ProblemType problemType = ProblemType.ERRO_INTERNO;
		String mensagem = "Ocorreu um erro interno no nosso servidor";
		
		ProblemBody problem = makeProblemBody(status, problemType, mensagem);
		
		return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
	}
}
