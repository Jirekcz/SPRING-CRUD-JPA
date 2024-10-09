package com.cibertec.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.api.dto.MedicamentoDTO;
import com.cibertec.api.entidad.Laboratorio;
import com.cibertec.api.entidad.Medicamento;
import com.cibertec.api.serviceImpl.MedicamentoService;
import com.cibertec.api.utils.MensajeResponse;
import com.cibertec.api.utils.ModelNotFoundException;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

import jakarta.validation.Valid;

// 4
@RestController
@RequestMapping("/medicamento")
public class MedicamentoController {

	@Autowired
	private MedicamentoService serviceMed;
	
	@Autowired
	private ModelMapper mapper;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar() throws Exception {
		List<Medicamento> lista = serviceMed.listar();
		if (lista.size() == 0) {
			return new ResponseEntity<>(MensajeResponse.builder().
					mensaje("No hay registros").object(null).build(), HttpStatus.OK);
		} else {
			List<MedicamentoDTO> lista2 = lista.stream().map(m->mapper.map(m, MedicamentoDTO.class)).collect(Collectors.toList());	
		
			return new ResponseEntity<>(MensajeResponse.builder().
					mensaje("Registros encontrados").object(lista2).build(), HttpStatus.OK);
		}
		
		
		
	}
	
	@GetMapping("/buscar/{codigo}")
	public ResponseEntity<?> buscar(@PathVariable Integer codigo) throws Exception {
		Medicamento bean = serviceMed.buscar(codigo);
		if (bean == null) {
			throw new ModelNotFoundException("Codigo no encontrado:" + codigo);
		} else {
			MedicamentoDTO med = mapper.map(bean, MedicamentoDTO.class);
			return new ResponseEntity<>(MensajeResponse.builder().
					mensaje("encontrado").object(med).build(), HttpStatus.OK);
		}
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrar(@Valid @RequestBody MedicamentoDTO bean) throws Exception {
		try {
			Medicamento med = mapper.map(bean, Medicamento.class);
			Medicamento medico = serviceMed.registrar(med);
			//
			return new ResponseEntity<>(MensajeResponse.builder().
					mensaje("correcto").object(med).build(), HttpStatus.CREATED);
		} catch (DataAccessException e) {
			return new ResponseEntity<>(MensajeResponse.builder().mensaje(e.getMessage()).object(null).build(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PutMapping("/actualizar")
	public ResponseEntity<?> actualizar(@Valid @RequestBody MedicamentoDTO bean) throws Exception {
		try {
			Medicamento med = serviceMed.buscar(bean.getCodigo());
			if (med == null) {
				throw new ModelNotFoundException("Codigo no encontrado: " + bean.getCodigo());
			} else {
				Medicamento m = serviceMed.actualizar(mapper.map(bean, Medicamento.class));
				return new ResponseEntity<>(MensajeResponse.builder().
						mensaje("correcto").object(mapper.map(m, MedicamentoDTO.class)).build(), HttpStatus.OK);
			}
		} catch (DataAccessException e) {
			return new ResponseEntity<>(MensajeResponse.builder().mensaje(e.getMessage()).object(null).build(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/eliminar/{codigo}")
	public ResponseEntity<Void> eliminar(@PathVariable Integer codigo) throws Exception {
		Medicamento med = serviceMed.buscar(codigo);
		if (med == null) {
			throw new ModelNotFoundException("Codigo no encontrado");
		} else {
			serviceMed.eliminar(codigo);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
	}
	
	
	
	
	
	
}
