package com.desafio.laboratorio.controle;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.laboratorio.dto.ExameDTO;
import com.desafio.laboratorio.entidade.Exame;
import com.desafio.laboratorio.servico.ExameServico;

@RestController
@RequestMapping("api/v1/exames")
public class ExameControle {

	@Autowired
	private ExameServico exameServico;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Exame> cadastrarExame(@Valid @RequestBody ExameDTO exameDTO) {
		return new ResponseEntity<Exame>(exameServico.cadastrarExame(exameDTO), HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Exame>> listarExames() {
		List<Exame> lista = exameServico.listarExames();
		if (ObjectUtils.isEmpty(lista)) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Exame>>(lista, HttpStatus.OK);
	}
}
