package com.desafio.laboratorio.controle;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.laboratorio.dto.LaboratorioDTO;
import com.desafio.laboratorio.entidade.Laboratorio;
import com.desafio.laboratorio.servico.LaboratorioServico;

@RestController
@RequestMapping("api/v1/laboratorios")
public class LaboratorioControle {

	@Autowired
	private LaboratorioServico laboratorioServico;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Laboratorio> cadastrarLaboratorio(@Valid @RequestBody LaboratorioDTO laboratorioDTO) {

		return new ResponseEntity<Laboratorio>(laboratorioServico.cadastrarLaboratorio(laboratorioDTO),
				HttpStatus.CREATED);
	}
}
