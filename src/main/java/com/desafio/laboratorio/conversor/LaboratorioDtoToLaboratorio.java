package com.desafio.laboratorio.conversor;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.desafio.laboratorio.dto.LaboratorioDTO;
import com.desafio.laboratorio.entidade.Laboratorio;

@Component
public class LaboratorioDtoToLaboratorio implements Converter<LaboratorioDTO, Laboratorio> {

	@Override
	public Laboratorio convert(LaboratorioDTO laboratorioDTO) {
		Laboratorio lab = new Laboratorio();
		lab.setNome(laboratorioDTO.getNome());
		lab.setEndereço(laboratorioDTO.getEndereco());
		lab.setStatus(laboratorioDTO.getStatus());
		return lab;
	}

}
