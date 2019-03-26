package com.desafio.laboratorio.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafio.laboratorio.entidade.Exame;

@Repository
public interface ExameRepositorio extends JpaRepository<Exame, Long> {

}
