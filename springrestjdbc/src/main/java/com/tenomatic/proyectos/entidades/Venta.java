package com.tenomatic.proyectos.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Venta {

	public Venta(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	private Long idVenta;
	private Long idFactura;
	private Long idProducto;
	private Integer cantidad;
}
