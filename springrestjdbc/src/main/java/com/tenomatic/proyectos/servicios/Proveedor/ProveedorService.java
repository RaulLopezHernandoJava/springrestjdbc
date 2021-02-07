package com.tenomatic.proyectos.servicios.Proveedor;

import com.tenomatic.proyectos.entidades.Proveedor;

public interface ProveedorService {

	Iterable<Proveedor> listar();

	Proveedor obtenerPorId(Long id);

	void agregar(Proveedor proveedor);

	Proveedor guardar(Proveedor proveedor);

	void borrar(Long id);
}
