package com.desafio.laboratorio.entidade;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "exame")
public class Exame {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idExame;
	private String nome;
	@Enumerated(EnumType.STRING)
	private TipoExame tipo;
	@Enumerated(EnumType.STRING)
	private Status status;

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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Long getIdExame() {
		return idExame;
	}

	@Override
	public String toString() {
		return "Exame [idExame=" + idExame + ", nome=" + nome + ", tipo=" + tipo + ", status=" + status + "]";
	}

}
