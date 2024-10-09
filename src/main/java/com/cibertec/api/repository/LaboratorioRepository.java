package com.cibertec.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cibertec.api.entidad.Laboratorio;

// 2
// Heredamos el interface JpaRepository
public interface LaboratorioRepository extends JpaRepository<Laboratorio, Integer>{

}
