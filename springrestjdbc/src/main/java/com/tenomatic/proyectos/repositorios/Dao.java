package com.tenomatic.proyectos.repositorios;

import org.springframework.stereotype.Controller;

import com.tenomatic.proyectos.entidades.Producto;

@Controller
public interface Dao<T> {
	
	default Iterable<T> obtenerTodos() {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	};

	default T obtenerPorId(Long id) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	};

	default T insertar(T objeto) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	};

	default T editar(T objeto) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	};

	default void borrar(Long id) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	};
	
}
