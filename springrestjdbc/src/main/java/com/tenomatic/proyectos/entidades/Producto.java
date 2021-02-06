package com.tenomatic.proyectos.entidades;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {

	private Long id;
	@NotBlank
	@Size(min = 3, max = 400)
	private String descripcion;
	private Integer precio;
	private Long idProveedor;
	private Long idCategoria;

}
