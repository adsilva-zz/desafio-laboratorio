package com.desafio.laboratorio.servico.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.desafio.laboratorio.dto.LaboratorioDTO;
import com.desafio.laboratorio.entidade.Laboratorio;
import com.desafio.laboratorio.entidade.Status;
import com.desafio.laboratorio.repositorio.LaboratorioRepositorio;
import com.desafio.laboratorio.servico.LaboratorioServico;

@Service
public class LaboratorioServicoImpl implements LaboratorioServico {

	@Autowired
	private LaboratorioRepositorio laboratorioRepositorio;

	@Autowired
	private ConversionService conversionService;

	@Override
	public Laboratorio cadastrarLaboratorio(LaboratorioDTO laboratorioDTO) {
		Laboratorio laboratorio = conversionService.convert(laboratorioDTO, Laboratorio.class);
		laboratorio.setStatus(Status.ATIVO);
		return laboratorioRepositorio.save(laboratorio);
	}

	@Override
	public List<Laboratorio> listarLaboratorio() {
		return laboratorioRepositorio.findByStatus(Status.ATIVO);
	}

	@Override
	public Laboratorio getLaboratorio(Long idLaboratorio) {
		Optional<Laboratorio> lab = laboratorioRepositorio.findById(idLaboratorio);
		return lab.get();
	}

	@Override
	public Laboratorio atualizarLaboratorio(LaboratorioDTO laboratorioDTO, Long idLaboratorio) {
		Laboratorio lab = getLaboratorio(idLaboratorio);
		if (ObjectUtils.isEmpty(lab)) {
			return null;
		}
		lab.setEndereço(laboratorioDTO.getEndereco());
		lab.setNome(laboratorioDTO.getNome());
		return laboratorioRepositorio.save(lab);
	}

	@Override
	public boolean deletarLaboratorio(Long idLaboratorio) {
		// TODO Auto-generated method stub
		return false;
	}

}
