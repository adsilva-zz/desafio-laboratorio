package com.desafio.laboratorio.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafio.laboratorio.entidade.Exame;
import com.desafio.laboratorio.entidade.Status;

@Repository
public interface ExameRepositorio extends JpaRepository<Exame, Long> {

	public List<Exame> findByStatus(Status status);
}
