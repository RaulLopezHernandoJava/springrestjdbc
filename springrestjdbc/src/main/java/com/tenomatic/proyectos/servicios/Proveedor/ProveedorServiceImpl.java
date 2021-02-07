package com.tenomatic.proyectos.servicios.Proveedor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tenomatic.proyectos.entidades.Proveedor;
import com.tenomatic.proyectos.repositorios.Dao;

@Service
public class ProveedorServiceImpl implements ProveedorService {

	@Autowired
	private Dao<Proveedor> dao;

	@Override
	public Iterable<Proveedor> listar() {
		return dao.obtenerTodos();
	}

	@Override
	public Proveedor obtenerPorId(Long id) {
		return dao.obtenerPorId(id);
	}

	@Override
	public void agregar(Proveedor proveedor) {
		dao.insertar(proveedor);
	}

	@Override
	public Proveedor guardar(Proveedor proveedor) {
		return dao.editar(proveedor);
	}

	@Override
	public void borrar(Long id) {
		dao.borrar(id);
	}

}
