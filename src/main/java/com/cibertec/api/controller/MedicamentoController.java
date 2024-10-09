package com.cibertec.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.api.entidad.Laboratorio;
import com.cibertec.api.entidad.Medicamento;
import com.cibertec.api.serviceImpl.MedicamentoService;
import com.cibertec.api.utils.ModelNotFoundException;

import jakarta.validation.Valid;

// 4
@RestController
@RequestMapping("/medicamento")
public class MedicamentoController {

	@Autowired
	private MedicamentoService serviceMed;
	
	@GetMapping("/listar")
	public List<Medicamento> listar() throws Exception {
		return serviceMed.listar();
	}
	
	@GetMapping("/buscar/{codigo}")
	public Medicamento buscar(@PathVariable Integer codigo) throws Exception {
		Medicamento bean = serviceMed.buscar(codigo);
		if (bean == null) {
			throw new ModelNotFoundException("Codigo no encontrado:" + codigo);
		} else {
			return serviceMed.buscar(codigo);
		}
	}
	
	@PostMapping("/registrar")
	public void registrar(@Valid @RequestBody Medicamento bean) throws Exception {
		serviceMed.registrar(bean);
	}
	
	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Medicamento bean) throws Exception {
		serviceMed.actualizar(bean);
	}
	
	@DeleteMapping("/eliminar/{codigo}")
	public void eliminar(@PathVariable Integer codigo) throws Exception {
		serviceMed.eliminar(codigo);
	}
	
	
	
	
	
	
}
