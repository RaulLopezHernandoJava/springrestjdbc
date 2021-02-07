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

import com.tenomatic.proyectos.entidades.Categoria;
import com.tenomatic.proyectos.servicios.Categoria.CategoriaService;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaApiController {

	@Autowired
	private CategoriaService categoriaService;

	// Sacamos todas las categorias de la base de datos
	@GetMapping
	public Iterable<Categoria> listar() {
		return categoriaService.listar();

	}

	// Encontrar categoria por id

	@GetMapping("{id}")
	public Categoria obtenerPorId(@PathVariable Long id) {
		;
		return categoriaService.obtenerPorId(id);
	}

	// Insertar categoria

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void agregar(@RequestBody Categoria categoria) {
		categoriaService.agregar(categoria);
	}

	// Actualizar categoria
	@PutMapping("{id}")
	public ResponseEntity<Categoria> put(@PathVariable Long id, @RequestBody Categoria categoria) {
		// Si los ids coinciden
		if (id == categoriaService.obtenerPorId(id).getId()) {
			// Si se devuelve el producto (Si el objetor producto existe)
			if (categoriaService.obtenerPorId(id) != null) {
				return new ResponseEntity<Categoria>(categoriaService.guardar(categoria), HttpStatus.OK);
			} else {
				return new ResponseEntity<Categoria>(HttpStatus.NOT_FOUND);
			}

		} else {
			return new ResponseEntity<Categoria>(HttpStatus.BAD_REQUEST);
		}
	}

	// Eliminar producto

	@DeleteMapping("{id}")
	public ResponseEntity<Categoria> delete(@PathVariable Long id) {
		if (categoriaService.obtenerPorId(id) != null) {
			categoriaService.borrar(id);
			return new ResponseEntity<Categoria>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<Categoria>(HttpStatus.NOT_FOUND);
		}
	}

}
