package com.desafio.laboratorio.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.desafio.laboratorio.entidade.Status;

public class AtualizarLabDTO {

	@NotEmpty
	private String nome;
	@NotEmpty
	private String endereco;
	@NotNull
	private Status status;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereço(String endereco) {
		this.endereco = endereco;
	}

}
