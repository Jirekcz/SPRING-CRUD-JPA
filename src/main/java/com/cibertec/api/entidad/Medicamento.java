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

// 1
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

	public Integer getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public int getStock() {
		return stock;
	}

	public double getPrecio() {
		return precio;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public Laboratorio getLaboratorio() {
		return laboratorio;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public void setLaboratorio(Laboratorio laboratorio) {
		this.laboratorio = laboratorio;
	}
	
	
}
