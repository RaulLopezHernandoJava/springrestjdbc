package com.tenomatic.proyectos.entidades;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Proveedor {

	private Long id;
	@NotBlank
	@Size(min = 3, max = 150)
	private String nombre;
	@NotBlank
	@Size(min = 3, max = 300)
	private String direccion;
	@NotBlank
	@Size(max = 9)
	private String telefono;
}
