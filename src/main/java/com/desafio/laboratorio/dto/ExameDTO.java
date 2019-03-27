package com.desafio.laboratorio.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.desafio.laboratorio.entidade.TipoExame;

public class ExameDTO {

	@NotEmpty
	private String nome;
	@NotNull
	private TipoExame tipo;

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
