package com.desafio.laboratorio.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafio.laboratorio.entidade.Laboratorio;

@Repository
public interface LaboratorioRepositorio extends JpaRepository<Laboratorio, Long> {

}
