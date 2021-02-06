package com.tenomatic.proyectos.servicios;

import com.tenomatic.proyectos.entidades.Producto;

public interface ProductoService {

	Iterable<Producto> listar();
	Producto obtenerPorId(Long id);
	void agregar(Producto producto);
	Producto guardar(Producto producto);
	void borrar(Long id);
}
