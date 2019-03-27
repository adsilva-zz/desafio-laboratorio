package com.desafio.laboratorio.controle;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.laboratorio.dto.AtualizarExemaDTO;
import com.desafio.laboratorio.dto.ExameDTO;
import com.desafio.laboratorio.dto.IdLaboratorioDTO;
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

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Exame> atualizarExame(@Valid @RequestBody AtualizarExemaDTO exameDTO,
			@PathVariable(value = "id") Long id) {
		Exame exame = exameServico.atualizarExame(id, exameDTO);
		if (ObjectUtils.isEmpty(exame)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Exame>(exame, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<Exame> buscarExame(@PathVariable(value = "id") Long idExame) {
		Exame exame = exameServico.getExame(idExame);
		if (ObjectUtils.isEmpty(exame)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Exame>(exame, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<Void> removerExame(@PathVariable(value = "id") Long idExame) {
		if (exameServico.removerExame(idExame)) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public ResponseEntity<Exame> associarExameComLaboratorio(@Valid @RequestBody IdLaboratorioDTO idLaboratorio,
			@PathVariable(value = "id") Long idExame) {
		Exame exame = exameServico.associarExameComLaboratorio(idExame, idLaboratorio);
		return new ResponseEntity<Exame>(exame, HttpStatus.OK);
	}
}
