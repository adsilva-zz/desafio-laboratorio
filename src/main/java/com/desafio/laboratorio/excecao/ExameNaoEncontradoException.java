package com.desafio.laboratorio.excecao;

public class ExameNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 710621422008791366L;
	private Long idExame;

	public ExameNaoEncontradoException(Long idExame) {
		this.idExame = idExame;
	}

	public Long getIdExame() {
		return idExame;
	}

	public void setIdExame(Long idExame) {
		this.idExame = idExame;
	}

}
