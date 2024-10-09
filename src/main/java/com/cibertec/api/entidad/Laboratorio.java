package com.cibertec.api.entidad;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

// 1
@Data
@Entity
@Table(name = "tb_laboratorio")
public class Laboratorio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_lab")
	private Integer codigo;
	
	@Column(name = "des_lab")
	private String descripcion;
	
	// Relacion 1 .. *
	@OneToMany(mappedBy = "laboratorio")
	@JsonIgnore
	private List<Medicamento> listaMedicamentos;
}
