package com.desafio.laboratorio.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafio.laboratorio.entidade.Laboratorio;
import com.desafio.laboratorio.entidade.Status;

@Repository
public interface LaboratorioRepositorio extends JpaRepository<Laboratorio, Long> {

	public List<Laboratorio> findByStatus(Status status);
	
	public Laboratorio findByIdLaboratorioAndStatus(Long idLaboratorio, Status status);
}
