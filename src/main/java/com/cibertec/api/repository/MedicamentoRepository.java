package com.cibertec.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cibertec.api.entidad.Medicamento;

// 2
public interface MedicamentoRepository extends JpaRepository<Medicamento, Integer>{

}
