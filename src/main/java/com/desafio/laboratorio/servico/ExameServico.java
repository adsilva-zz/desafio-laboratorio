package com.desafio.laboratorio.servico;

import java.util.List;

import com.desafio.laboratorio.dto.AtualizarExemaDTO;
import com.desafio.laboratorio.dto.ExameDTO;
import com.desafio.laboratorio.dto.IdLaboratorioDTO;
import com.desafio.laboratorio.entidade.Exame;
import com.desafio.laboratorio.entidade.Laboratorio;

public interface ExameServico {

	public Exame cadastrarExame(ExameDTO exameDTO);

	public List<Exame> listarExames();

	public Exame getExame(Long idExame);

	public Exame atualizarExame(Long idExame, AtualizarExemaDTO exameDTO);

	public boolean removerExame(Long idExame);

	public Exame associarExameComLaboratorio(Long idExame, IdLaboratorioDTO idLaboratorio);

	public List<Laboratorio> listarLaboratoriosAssociados(String nome);

}
