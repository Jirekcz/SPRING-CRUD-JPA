package com.cibertec.api.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.cibertec.api.entidad.Laboratorio;
import com.cibertec.api.repository.LaboratorioRepository;
import com.cibertec.api.service.ICrud;

// 3
@Service
public class LaboratorioService extends ICrudImpl<Laboratorio, Integer>{

	@Autowired
	private LaboratorioRepository repo;

	@Override
	public JpaRepository<Laboratorio, Integer> getJpaRepository() {
		// TODO Auto-generated method stub
		return repo;
	}

	
	/*
	 * public void registrar(Laboratorio bean) { repo.save(bean); // ID ---> 0 }
	 * 
	 * public void actualizar(Laboratorio bean) { repo.save(bean); // ID existe }
	 * 
	 * public void eliminar(Integer cod) { repo.deleteById(cod); }
	 * 
	 * // Optional<Laboratorio> es por si el codigo que busca es nulo. public
	 * Laboratorio buscar(Integer cod) { return repo.findById(cod).orElse(null); //
	 * Reemplazo Optional por .orElse(null) }
	 * 
	 * public List<Laboratorio> listar() { return repo.findAll(); }
	 */
}
