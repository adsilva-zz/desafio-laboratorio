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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.laboratorio.dto.AtualizarLabDTO;
import com.desafio.laboratorio.dto.LaboratorioDTO;
import com.desafio.laboratorio.entidade.Laboratorio;
import com.desafio.laboratorio.servico.ExameServico;
import com.desafio.laboratorio.servico.LaboratorioServico;

@RestController
@RequestMapping("api/v1/laboratorios")
public class LaboratorioControle {

	@Autowired
	private LaboratorioServico laboratorioServico;

	@Autowired
	private ExameServico exameServico;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Laboratorio> cadastrarLaboratorio(@Valid @RequestBody LaboratorioDTO laboratorioDTO) {
		return new ResponseEntity<Laboratorio>(laboratorioServico.cadastrarLaboratorio(laboratorioDTO),
				HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Laboratorio>> listarLaboratorios(
			@RequestParam(name = "nome", required = false) String nomeExame) {
		List<Laboratorio> lista;
		if (!ObjectUtils.isEmpty(nomeExame)) {
			lista = exameServico.listarLaboratoriosAssociados(nomeExame);
		} else {
			lista = laboratorioServico.listarLaboratorio();
		}
		if (ObjectUtils.isEmpty(lista)) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Laboratorio>>(lista, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<Laboratorio> buscarLaboratorio(@PathVariable(value = "id") Long id) {
		Laboratorio lab = laboratorioServico.getLaboratorio(id);
		if (ObjectUtils.isEmpty(lab)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Laboratorio>(lab, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Laboratorio> atualizarLaboratorio(@PathVariable(value = "id") Long id,
			@Valid @RequestBody AtualizarLabDTO laboratorioDTO) {
		Laboratorio lab = laboratorioServico.atualizarLaboratorio(laboratorioDTO, id);
		if (ObjectUtils.isEmpty(lab)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Laboratorio>(lab, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> removerLaboratorio(@PathVariable(value = "id") Long id) {
		if (!laboratorioServico.deletarLaboratorio(id)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
