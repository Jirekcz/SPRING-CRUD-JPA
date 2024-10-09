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

// 1
@Entity
@Table(name = "tb_medicamento")
@Data
public class Medicamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_med")
	private Integer codigo;
	
	@Column(name = "nom_med")
	@NotNull(message = "El nombre del medicamento es obligatorio")
	private String nombre;
	
	@Column(name = "stock_med")
	@Min(value = 1, message = "Campo stock MIN: 1")
	@Max(value = 9, message = "Campo stock MAX: 9")
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
