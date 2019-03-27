package com.desafio.laboratorio.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.desafio.laboratorio.entidade.Status;
import com.desafio.laboratorio.entidade.TipoExame;

public class AtualizarExemaDTO {

	@NotEmpty
	private String nome;
	@NotNull
	private TipoExame tipo;
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

	public TipoExame getTipo() {
		return tipo;
	}

	public void setTipo(TipoExame tipo) {
		this.tipo = tipo;
	}
}
