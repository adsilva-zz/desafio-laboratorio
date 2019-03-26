package com.desafio.laboratorio.dto;

import javax.validation.constraints.NotEmpty;

public class LaboratorioDTO {

	@NotEmpty
	private String nome;
	@NotEmpty
	private String endereco;

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
