package com.cibertec.api.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MedicamentoDTO {
	private Integer codigo;
	@NotNull(message = "Campo nombre no puede ser nulo")
	private String nombre;
	@Min(value = 1, message = "Campo stock MIN: 1")
	@Max(value = 9, message = "Campo stock MAX: 9")
	private int stock;
	private double precio;
	private LocalDate fecha;
	private LaboratorioDTO laboratorio;
}
