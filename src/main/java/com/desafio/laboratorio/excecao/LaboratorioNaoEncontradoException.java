package com.desafio.laboratorio.excecao;

public class LaboratorioNaoEncontradoException extends RuntimeException{

	private static final long serialVersionUID = 2962454933646916037L;
	private Long idLaboratorio;

	public LaboratorioNaoEncontradoException(Long idLaboratorio) {
		this.idLaboratorio = idLaboratorio;
	}

	public Long getIdLaboratorio() {
		return idLaboratorio;
	}

	public void setIdLaboratorio(Long idLaboratorio) {
		this.idLaboratorio = idLaboratorio;
	}
	
}
