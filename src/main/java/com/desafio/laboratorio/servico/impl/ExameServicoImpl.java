package com.desafio.laboratorio.servico.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.desafio.laboratorio.dto.AtualizarExemaDTO;
import com.desafio.laboratorio.dto.ExameDTO;
import com.desafio.laboratorio.dto.IdLaboratorioDTO;
import com.desafio.laboratorio.entidade.Exame;
import com.desafio.laboratorio.entidade.Laboratorio;
import com.desafio.laboratorio.entidade.Status;
import com.desafio.laboratorio.excecao.ExameNaoEncontradoException;
import com.desafio.laboratorio.excecao.LaboratorioNaoEncontradoException;
import com.desafio.laboratorio.repositorio.ExameRepositorio;
import com.desafio.laboratorio.servico.ExameServico;
import com.desafio.laboratorio.servico.LaboratorioServico;

@Service
public class ExameServicoImpl implements ExameServico {

	@Autowired
	private ExameRepositorio exameRepositorio;

	@Autowired
	private LaboratorioServico laboratorioServico;

	@Autowired
	private ConversionService conversionService;

	@Override
	public Exame cadastrarExame(ExameDTO exameDTO) {
		Exame exame = conversionService.convert(exameDTO, Exame.class);
		exame.setStatus(Status.ATIVO);
		return exameRepositorio.save(exame);
	}

	@Override
	public List<Exame> listarExames() {
		return exameRepositorio.findByStatus(Status.ATIVO);
	}

	@Override
	public Exame getExame(Long idExame) {
		Optional<Exame> exame = exameRepositorio.findById(idExame);
		if (ObjectUtils.isEmpty(exame)) {
			return null;
		}
		return exame.orElse(null);
	}

	public Exame getExameAtivo(Long idExame) {
		Exame exame = exameRepositorio.findByIdExameAndStatus(idExame, Status.ATIVO);
		return exame;
	}

	@Override
	public Exame atualizarExame(Long idExame, AtualizarExemaDTO exameDTO) {
		Exame exame = getExame(idExame);
		if (ObjectUtils.isEmpty(exame)) {
			return null;
		}
		exame.setNome(exameDTO.getNome());
		exame.setTipo(exameDTO.getTipo());
		exame.setStatus(exameDTO.getStatus());
		return exameRepositorio.save(exame);
	}

	@Override
	public boolean removerExame(Long idExame) {
		Exame exame = getExameAtivo(idExame);
		if (ObjectUtils.isEmpty(exame)) {
			return false;
		}
		exame.setStatus(Status.INATIVO);
		exameRepositorio.save(exame);
		return true;
	}

	@Override
	public Exame associarExameComLaboratorio(Long idExame, IdLaboratorioDTO idLaboratorio) {
		Exame exame = getExame(idExame);
		if (ObjectUtils.isEmpty(exame)) {
			throw new ExameNaoEncontradoException(idExame);
		}
		Laboratorio lab = laboratorioServico.getLaboratorio(idLaboratorio.getIdLaboratorio());
		if (ObjectUtils.isEmpty(lab)) {
			throw new LaboratorioNaoEncontradoException(idLaboratorio.getIdLaboratorio());
		}
		exame.getListaLaboratorios().add(lab);
		return exameRepositorio.save(exame);
	}

	@Override
	public List<Laboratorio> listarLaboratoriosAssociados(String nome) {
		Exame exame = exameRepositorio.findByNome(nome);
		if (ObjectUtils.isEmpty(exame)) {
			return null;
		}
		return exame.getListaLaboratorios();
	}

	@Override
	public Exame desassociarExameDeLaboratorio(Long idExame, IdLaboratorioDTO idLaboratorio) {
		Exame exame = getExame(idExame);
		if (ObjectUtils.isEmpty(exame)) {
			throw new ExameNaoEncontradoException(idExame);
		}
		Laboratorio lab = null;
		for (Laboratorio l : exame.getListaLaboratorios()) {
			if (l.getIdLaboratorio().equals(idLaboratorio.getIdLaboratorio())) {
				lab = l;
			}
		}
		if (ObjectUtils.isEmpty(lab)) {
			return null;
		}
		exame.getListaLaboratorios().remove(lab);
		return exameRepositorio.save(exame);
	}
}
