package com.desafio.laboratorio.excecao;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControleAdviceCustom {

	@ExceptionHandler(ExameNaoEncontradoException.class)
	public ResponseEntity<Message<Long>> exameNaoEncontradoException(ExameNaoEncontradoException ex) {
		Message<Long> mensagem = new Message<>("Exame não encontrado", ex.getIdExame());
		return new ResponseEntity<Message<Long>>(mensagem, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(LaboratorioNaoEncontradoException.class)
	public ResponseEntity<Message<Long>> laboratorioNaoEcontradoException(LaboratorioNaoEncontradoException ex) {
		Message<Long> mensagem = new Message<>("Laboratório não encontrado", ex.getIdLaboratorio());
		return new ResponseEntity<Message<Long>>(mensagem, HttpStatus.BAD_REQUEST);
	}
}
