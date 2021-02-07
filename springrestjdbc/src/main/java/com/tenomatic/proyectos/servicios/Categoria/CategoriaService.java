package com.tenomatic.proyectos.servicios.Categoria;

import com.tenomatic.proyectos.entidades.Categoria;

public interface CategoriaService {
	
	Iterable<Categoria> listar();
	Categoria obtenerPorId(Long id);
	void agregar(Categoria categoria);
	Categoria guardar(Categoria categoria);
	void borrar(Long id);
}
