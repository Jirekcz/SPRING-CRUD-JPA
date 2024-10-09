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
import com.cibertec.api.serviceImpl.LaboratorioService;
import com.cibertec.api.utils.ModelNotFoundException;

// 4
@RestController // Para clases que contengan metodos que tendran endpoints
@RequestMapping("/laboratorio")
public class LaboratorioController {

	@Autowired
	private LaboratorioService serviceLab;
	
	@GetMapping("/listar") // Es como un select, retorna JSON
	public List<Laboratorio> listado() throws Exception {
		return serviceLab.listar();
	}
	
	@GetMapping("/buscar/{codigo}")
	public Laboratorio buscarPorId(@PathVariable Integer codigo) throws Exception {
		Laboratorio bean = serviceLab.buscar(codigo);
		if (bean == null) {
			throw new ModelNotFoundException("Codigo no encontrado:" + codigo);
		} else {
			return serviceLab.buscar(codigo);
		}
	}
	
	@PostMapping("/registrar")
	public void regisrar(@RequestBody Laboratorio bean) throws Exception {
		serviceLab.registrar(bean);
	}
	
	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Laboratorio bean) throws Exception {
		serviceLab.actualizar(bean);
	}
	
	@DeleteMapping("/eliminar/{codigo}")
	public void eliminar(@PathVariable Integer codigo) throws Exception {
		serviceLab.eliminar(codigo);
	}
	
}
