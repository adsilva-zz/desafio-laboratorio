package com.desafio.laboratorio.servico.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.desafio.laboratorio.dto.AtualizarExemaDTO;
import com.desafio.laboratorio.dto.ExameDTO;
import com.desafio.laboratorio.entidade.Exame;
import com.desafio.laboratorio.entidade.Status;
import com.desafio.laboratorio.repositorio.ExameRepositorio;
import com.desafio.laboratorio.servico.ExameServico;

@Service
public class ExameServicoImpl implements ExameServico {

	@Autowired
	private ExameRepositorio exameRepositorio;

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
		return exame.get();
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
		Exame exame = getExame(idExame);
		if (ObjectUtils.isEmpty(exame)) {
			return false;
		}
		exame.setStatus(Status.INATIVO);
		exameRepositorio.save(exame);
		return true;
	}

}
