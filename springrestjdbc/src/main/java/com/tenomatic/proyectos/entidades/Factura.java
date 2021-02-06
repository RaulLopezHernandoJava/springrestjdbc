package com.tenomatic.proyectos.entidades;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data @AllArgsConstructor @NoArgsConstructor
public class Factura {
	
	private Long id ;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fecha;
	private Long idCliente ;
}


