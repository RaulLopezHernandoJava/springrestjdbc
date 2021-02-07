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
	
	public Producto(Long id, String descripcion,Integer precio, Long idProveedor, Long idCategoria) {
		this.id=id;
		this.descripcion=descripcion;
		this.precio = precio;
		this.idProveedor = idProveedor;
		this.idCategoria=idCategoria;
		
	}
	

	private Long id;
	@NotBlank
	@Size(min = 3, max = 400)
	private String descripcion;
	private Integer precio;
	private Long idProveedor;
	private Long idCategoria;
	private Venta venta;
	private Proveedor proveedor;
	
	

	
}
