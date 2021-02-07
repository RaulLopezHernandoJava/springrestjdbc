package com.tenomatic.proyectos.servicios.Producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenomatic.proyectos.entidades.Producto;
import com.tenomatic.proyectos.repositorios.Dao;

import lombok.extern.java.Log;

@Log
@Service
public class ProductoServiceImpl implements ProductoService {
	
	@Autowired
	private Dao<Producto> dao;
	
	
	@Override
	public Iterable<Producto> listar() {
		return dao.obtenerTodos();
	}

	@Override
	public Producto obtenerPorId(Long id) {
		return dao.obtenerPorId(id);
	}

	@Override
	public void agregar(Producto producto) {
		dao.insertar(producto);
		
	}

	@Override
	public Producto guardar(Producto producto) {
		log.info("Antes de guardar un producto");
		return dao.editar(producto);
		
	}

	@Override
	public void borrar(Long id) {
		dao.borrar(id);
		
	}
	
}
