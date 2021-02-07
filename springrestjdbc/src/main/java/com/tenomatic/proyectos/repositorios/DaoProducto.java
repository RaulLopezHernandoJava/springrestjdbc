package com.tenomatic.proyectos.repositorios;

import org.springframework.stereotype.Controller;

import com.tenomatic.proyectos.entidades.Producto;

@Controller
public interface DaoProducto extends Dao<Producto> {
	public Iterable<Producto> obtenerProductosPorCategoria(Long id);
}
