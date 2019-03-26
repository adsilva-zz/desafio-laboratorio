package com.desafio.laboratorio.entidade;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "laboratorio")
public class Laboratorio {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idLaboratorio;
	private String nome;
	private String endereço;
	@Enumerated(EnumType.STRING)
	private Status status;

	public Long getIdLaboratorio() {
		return idLaboratorio;
	}

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

	@Override
	public String toString() {
		return "Laboratorio [idLaboratorio=" + idLaboratorio + ", nome=" + nome + ", endereço=" + endereço + ", status="
				+ status + "]";
	}

}
