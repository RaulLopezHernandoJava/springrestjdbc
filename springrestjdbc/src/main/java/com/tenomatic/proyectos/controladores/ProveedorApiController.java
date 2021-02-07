package com.tenomatic.proyectos.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tenomatic.proyectos.entidades.Proveedor;
import com.tenomatic.proyectos.repositorios.Proveedor.ProveedoresDaoMySql;
import com.tenomatic.proyectos.servicios.Proveedor.ProveedorService;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedorApiController {

	@Autowired
	private ProveedorService proveedorService;

	@Autowired
	private ProveedoresDaoMySql metodosProveedores;

	// Sacamos todos los proveedores de la base de datos

	@GetMapping
	public Iterable<Proveedor> listar() {
		return proveedorService.listar();

	}

	// Encontrar por id proveedor

	@GetMapping("{id}")
	public Proveedor obtenerPorId(@PathVariable Long id) {
		return proveedorService.obtenerPorId(id);
	}

	// Insertar proveedor

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void agregar(@RequestBody Proveedor proveedor) {
		proveedorService.agregar(proveedor);
	}

	// Actualizar proveedor
	@PutMapping("{id}")
	public ResponseEntity<Proveedor> put(@PathVariable Long id, @RequestBody Proveedor proveedor) {

		if (id == proveedorService.obtenerPorId(id).getId()) {
			if (proveedorService.obtenerPorId(id) != null) {
				return new ResponseEntity<Proveedor>(proveedorService.guardar(proveedor), HttpStatus.OK);
			} else {
				return new ResponseEntity<Proveedor>(HttpStatus.NOT_FOUND);
			}

		} else {
			return new ResponseEntity<Proveedor>(HttpStatus.BAD_REQUEST);
		}
	}

	// Eliminar proveedor

	@DeleteMapping("{id}")
	public ResponseEntity<Proveedor> delete(@PathVariable Long id) {
		if (proveedorService.obtenerPorId(id) != null) {
			proveedorService.borrar(id);
			return new ResponseEntity<Proveedor>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<Proveedor>(HttpStatus.NOT_FOUND);
		}
	}

}
