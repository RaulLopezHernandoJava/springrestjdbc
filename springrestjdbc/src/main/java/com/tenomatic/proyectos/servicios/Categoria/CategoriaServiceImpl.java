package com.tenomatic.proyectos.servicios.Categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenomatic.proyectos.entidades.Categoria;
import com.tenomatic.proyectos.repositorios.Dao;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	private Dao<Categoria> dao;
	

	@Override
	public Iterable<Categoria> listar() {
		return dao.obtenerTodos();
	}

	@Override
	public Categoria obtenerPorId(Long id) {
		return dao.obtenerPorId(id);
	}

	@Override
	public void agregar(Categoria categoria) {
		dao.insertar(categoria);

	}

	@Override
	public Categoria guardar(Categoria categoria) {

		return dao.editar(categoria);
	}

	@Override
	public void borrar(Long id) {
		dao.borrar(id);

	}

}
