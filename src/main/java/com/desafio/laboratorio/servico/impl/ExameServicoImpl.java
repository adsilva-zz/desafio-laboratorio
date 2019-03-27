package com.desafio.laboratorio.servico.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Exame getExame(Long idExame) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Exame atualizarExame(Long idExame, ExameDTO exameDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removerExame(Long idExame) {
		// TODO Auto-generated method stub
		return false;
	}

}
