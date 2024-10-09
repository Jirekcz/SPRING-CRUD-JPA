package com.cibertec.api.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.cibertec.api.entidad.Medicamento;
import com.cibertec.api.repository.MedicamentoRepository;
import com.cibertec.api.service.ICrud;

// 3
@Service
public class MedicamentoService extends ICrudImpl<Medicamento, Integer>{

	@Autowired
	private MedicamentoRepository repo;

	@Override
	public JpaRepository<Medicamento, Integer> getJpaRepository() {
		// TODO Auto-generated method stub
		return repo;
	}

	
	/*
	 * public void registrar(Medicamento bean) { repo.save(bean); }
	 * 
	 * public void actualizar(Medicamento bean) { repo.save(bean); }
	 * 
	 * public void eliminar(Integer cod) { repo.deleteById(cod); }
	 * 
	 * public Medicamento buscar(Integer cod) { return
	 * repo.findById(cod).orElse(null); }
	 * 
	 * public List<Medicamento> listar() { return repo.findAll(); }
	 */
}
