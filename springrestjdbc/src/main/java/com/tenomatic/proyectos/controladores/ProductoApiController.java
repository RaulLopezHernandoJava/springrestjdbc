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

import com.tenomatic.proyectos.entidades.Producto;
import com.tenomatic.proyectos.repositorios.Producto.ProductosDaoMySql;
import com.tenomatic.proyectos.servicios.Producto.ProductoService;

@RestController
@RequestMapping("/api/productos")
public class ProductoApiController {

	@Autowired
	private ProductoService productoService;

	@Autowired
	private ProductosDaoMySql metodosProductos;
	// Sacamos todos los productos de la base de datos
	@GetMapping
	public Iterable<Producto> listar() {
		return productoService.listar();

	}

	// Encontrar producto por id

	@GetMapping("{id}")
	public Producto obtenerPorId(@PathVariable Long id) {
		;
		return productoService.obtenerPorId(id);
	}

	// Insertar producto

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void agregar(@RequestBody Producto producto) {
		productoService.agregar(producto);
	}

	// Actualizar producto
	@PutMapping("{id}")
	public ResponseEntity<Producto> put(@PathVariable Long id, @RequestBody Producto producto) {
		System.out.println(producto);
		// Si los ids coinciden
		if (id == productoService.obtenerPorId(id).getId()) {
			// Si se devuelve el producto (Si el objetor producto existe)
			if (productoService.obtenerPorId(id) != null) {
				return new ResponseEntity<Producto>(productoService.guardar(producto), HttpStatus.OK);
			} else {
				return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
			}

		} else {
			return new ResponseEntity<Producto>(HttpStatus.BAD_REQUEST);
		}
	}

	// Eliminar producto

	@DeleteMapping("{id}")
	public ResponseEntity<Producto> delete(@PathVariable Long id) {
		if (productoService.obtenerPorId(id) != null) {
			productoService.borrar(id);
			return new ResponseEntity<Producto>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
		}
	}
	
	// Obtener los productos de la categoria X
	
	@GetMapping("/categoria/{id}")
	public Iterable<Producto> obtenerProductosPorCategoria(@PathVariable Long id){
		return  metodosProductos.obtenerProductosPorCategoria(id);
		
	}
	
	// Obtener los productos del proveedor X
	
	@GetMapping("/proveedor/{id}")
	public Iterable<Producto> obtenerProductosPorProveedor(@PathVariable Long id){
		return  metodosProductos.obtenerProductosPorProveedor(id);
	}
	
	//Obtener las ventas de un producto asi como los datos de su proveedor
	
	@GetMapping("/proveedor/venta/{id}")
	public Iterable<Producto> obtenerVentasDatosProveedorProducto (@PathVariable Long id){
		return metodosProductos.obtenerVentasDatosProveedorProducto(id);
		
	}
	
	

}
