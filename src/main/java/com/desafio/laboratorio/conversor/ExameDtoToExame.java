package com.desafio.laboratorio.conversor;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.desafio.laboratorio.dto.ExameDTO;
import com.desafio.laboratorio.entidade.Exame;

@Component
public class ExameDtoToExame implements Converter<ExameDTO, Exame> {

	@Override
	public Exame convert(ExameDTO exameDTO) {
		Exame exame = new Exame();
		exame.setNome(exameDTO.getNome());
		exame.setTipo(exameDTO.getTipo());
		return exame;
	}

}
