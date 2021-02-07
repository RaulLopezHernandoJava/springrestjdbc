package com.tenomatic.proyectos.repositorios.Producto;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.tenomatic.proyectos.entidades.Producto;
import com.tenomatic.proyectos.entidades.Proveedor;
import com.tenomatic.proyectos.entidades.Venta;
import com.tenomatic.proyectos.repositorios.Dao;

@Repository
public class ProductosDaoMySql implements Dao<Producto> {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private DataSource dataSource;

	// Obtener todos los productos FUNCIONANDO

	public Iterable<Producto> obtenerTodos() {

		return jdbcTemplate.query("SELECT * FROM productos",
				(rs, rowNum) -> new Producto(rs.getLong("id_producto"), rs.getString("descripcion"),
						rs.getInt("precio"), rs.getLong("id_proveedor"), rs.getLong("id_categoria")));

	}

	// Obtener producto por Id FUNCIONANDO
	@Override
	public Producto obtenerPorId(Long id) {
		return jdbcTemplate.queryForObject("select * from productos p where p.id_producto = ?",
				(rs, rowNum) -> new Producto(rs.getLong("p.id_producto"), rs.getString("p.descripcion"),
						rs.getInt("p.precio"), rs.getLong("p.id_proveedor"), rs.getLong("p.id_categoria")),
				id);

	}

	// Insertar producto FUNCIONANDO
	@Override
	public Producto insertar(Producto producto) {
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("productos")
				.usingGeneratedKeyColumns("id");
		Map<String, Object> parameters = new HashMap<>(1);

		parameters.put("descripcion", producto.getDescripcion());
		parameters.put("precio", producto.getPrecio());
		parameters.put("id_proveedor", producto.getIdProveedor());
		parameters.put("id_categoria", producto.getIdCategoria());

		Long newId = simpleJdbcInsert.executeAndReturnKey(parameters).longValue();
		producto.setId(newId);

		return producto;
	}

	// Edita Producto FUNCIONANDO
	@Override
	public Producto editar(Producto producto) {
		jdbcTemplate.update(
				"UPDATE productos SET descripcion = ?, precio = ?, id_proveedor = ?, id_categoria = ? WHERE id_producto = ?",
				new Object[] { producto.getDescripcion(), producto.getPrecio(), producto.getIdProveedor(),
						producto.getIdCategoria(), producto.getId() });
		return producto;
	}

	// Eliminar producto funcionando
	@Override
	public void borrar(Long id) {
		jdbcTemplate.update("DELETE FROM productos WHERE id_producto = ?", new Object[] { id });
	}

	// Obtener productos por categoria FUNCIONANDO
	public Iterable<Producto> obtenerProductosPorCategoria(Long id) {

		return jdbcTemplate.query("select *  from productos p  where p.Id_categoria = ?",(rs,rowNum)->
		new Producto(rs.getLong("p.id_producto"), rs.getString("p.descripcion"),rs.getInt("p.precio"), rs.getLong("p.id_proveedor"), 
		rs.getLong("p.id_categoria")),id);
	}
	
	// Obtener los productos de un mismo proveedor FUNCIONANDO
	public Iterable<Producto> obtenerProductosPorProveedor(Long id){
	return jdbcTemplate.query("select *  from productos p  where p.id_proveedor = ?",(rs,rowNum)->
	new Producto(rs.getLong("p.id_producto"), rs.getString("p.descripcion"),rs.getInt("p.precio"), rs.getLong("p.id_proveedor"), 
	rs.getLong("p.id_categoria")),id);
	}
	
	// Obtener las ventas de un producto asi como los datos de su proveedor
	
	public Iterable<Producto> obtenerVentasDatosProveedorProducto (@PathVariable Long id){
		return jdbcTemplate.query("select p.*, v.cantidad, pr.* from productos p JOIN proveedores pr ON p.id_proveedor = pr.id_proveedor JOIN ventas v ON v.id_producto = p.id_producto WHERE p.id_producto = ?",(rs,rowNum)-> new Producto (rs.getLong("p.id_producto"), rs.getString("p.descripcion"),rs.getInt("p.precio"), rs.getLong("p.id_proveedor"), rs.getLong("p.id_categoria"),new Venta(rs.getInt("v.cantidad")),new Proveedor(rs.getLong("pr.id_proveedor"),rs.getString("pr.nombre"),rs.getString("pr.direccion"),rs.getString("pr.telefono"))),id); 
		
	}

}
