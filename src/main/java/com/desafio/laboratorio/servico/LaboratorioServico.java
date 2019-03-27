package com.desafio.laboratorio.servico;

import java.util.List;

import com.desafio.laboratorio.dto.AtualizarLabDTO;
import com.desafio.laboratorio.dto.LaboratorioDTO;
import com.desafio.laboratorio.entidade.Laboratorio;

public interface LaboratorioServico {

	public Laboratorio cadastrarLaboratorio(LaboratorioDTO laboratorioDTO);

	public List<Laboratorio> listarLaboratorio();

	public Laboratorio getLaboratorio(Long idLaboratorio);

	public Laboratorio atualizarLaboratorio(AtualizarLabDTO laboratorioDTO, Long idLaboratorio);

	public boolean deletarLaboratorio(Long idLaboratorio);
}
