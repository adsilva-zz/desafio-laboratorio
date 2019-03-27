package com.desafio.laboratorio.entidade;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "laboratorio")
@JsonInclude(Include.NON_NULL)
public class Laboratorio {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idLaboratorio;
	private String nome;
	private String endereço;
	@Enumerated(EnumType.STRING)
	private Status status;
	@ManyToMany(mappedBy = "listaLaboratorios")
	@JsonManagedReference
	private List<Exame> listaExames;

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

	public List<Exame> getListaExames() {
		return listaExames;
	}

	public void setListaExames(List<Exame> listaExames) {
		this.listaExames = listaExames;
	}

	@Override
	public String toString() {
		return "Laboratorio [idLaboratorio=" + idLaboratorio + ", nome=" + nome + ", endereço=" + endereço + ", status="
				+ status + "]";
	}

}
