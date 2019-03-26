package com.desafio.laboratorio.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.desafio.laboratorio.entidade.Status;

public class LaboratorioDTO {

	@NotEmpty
	private String nome;
	@NotEmpty
	private String endereço;
	@NotNull
	private Status status;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereço() {
		return endereço;
	}

	public void setEndereço(String endereço) {
		this.endereço = endereço;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
