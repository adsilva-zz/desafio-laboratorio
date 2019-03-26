package com.desafio.laboratorio.servico;

import java.util.List;

import org.springframework.stereotype.Service;

import com.desafio.laboratorio.dto.LaboratorioDTO;
import com.desafio.laboratorio.entidade.Laboratorio;

@Service
public interface LaboratorioServico {

	public Laboratorio cadastrarLaboratorio(LaboratorioDTO laboratorioDTO);

	public List<Laboratorio> listarLaboratorio();

	public Laboratorio getLaboratorio(Long idLaboratorio);

	public boolean atualizarLaboratorio(LaboratorioDTO laboratorioDTO, Long idLaboratorio);

	public boolean deletarLaboratorio(Long idLaboratorio);
}
