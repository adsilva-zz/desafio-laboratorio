package com.desafio.laboratorio.dto;

import javax.validation.constraints.NotNull;

public class IdLaboratorioDTO {

	@NotNull
	private Long idLaboratorio;

	public Long getIdLaboratorio() {
		return idLaboratorio;
	}

	public void setIdLaboratorio(Long idLaboratorio) {
		this.idLaboratorio = idLaboratorio;
	}

}
