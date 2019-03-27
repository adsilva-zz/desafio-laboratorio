package com.desafio.laboratorio.entidade;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
	@ManyToMany(mappedBy = "listaExames")
	@JsonBackReference
	private List<Laboratorio> listaLaboratorios;

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

	public List<Laboratorio> getListaLaboratorios() {
		return listaLaboratorios;
	}

	public void setListaLaboratorios(List<Laboratorio> listaLaboratorios) {
		this.listaLaboratorios = listaLaboratorios;
	}

	@Override
	public String toString() {
		return "Exame [idExame=" + idExame + ", nome=" + nome + ", tipo=" + tipo + ", status=" + status + "]";
	}

}
