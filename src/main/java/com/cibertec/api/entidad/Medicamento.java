package com.cibertec.api.entidad;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

// 1
@Data
@Entity
@Table(name = "tb_medicamento")
public class Medicamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_med")
	private Integer codigo;
	
	@Column(name = "nom_med")
	private String nombre;
	
	@Column(name = "stock_med")
	private int stock;
	
	@Column(name = "pre_med")
	private double precio;
	
	@Column(name = "fec_ven_med")
	private LocalDate fecha;
	
	// Bi-direccional
	@ManyToOne
	@JoinColumn(name = "cod_lab")
	private Laboratorio laboratorio; // Asosiacion
}
