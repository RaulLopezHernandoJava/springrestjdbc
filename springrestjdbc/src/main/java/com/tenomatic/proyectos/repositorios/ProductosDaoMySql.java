package com.tenomatic.proyectos.repositorios;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.tecnomatic.proyectos.rowmappers.ProductoRowMapper;
import com.tenomatic.proyectos.entidades.Producto;

@Repository
public class ProductosDaoMySql implements Dao <Producto> {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private DataSource dataSource;
	
	
	// Obtener todos los productos FUNCIONANDO
	
	public Iterable<Producto> obtenerTodos() {
		
		return jdbcTemplate.query("SELECT * FROM productos",
				(rs, rowNum) -> new Producto(rs.getLong("id_producto"), rs.getString("descripcion"), rs.getInt("precio"),
				rs.getLong("id_proveedor"),rs.getLong("id_categoria")));
				
					
	}
	
	// Obtener producto por Id FUNCIONANDO
	@Override
	public Producto obtenerPorId(Long id) {
		return jdbcTemplate.queryForObject("select * from productos p where p.id_producto = ?",(rs,rowNum)-> 
		new Producto(rs.getLong("p.id_producto"),rs.getString("p.descripcion"),rs.getInt("p.precio"),rs.getLong("p.id_proveedor"),rs.getLong("p.id_categoria")),id);
	        
	}
	
	
	//Insertar producto FUNCIONANDO
	@Override
	public Producto insertar(Producto producto) {
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("productos").usingGeneratedKeyColumns("id");
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
		jdbcTemplate.update("UPDATE productos SET descripcion = ?, precio = ?, id_proveedor = ?, id_categoria = ? WHERE id_producto = ?",
				new Object[] { producto.getDescripcion(), producto.getPrecio(), producto.getIdProveedor(), producto.getIdCategoria(),producto.getId()});
		return producto;
	}
	
	
	// Eliminar producto funcionando
	@Override
	public void borrar(Long id) {
		jdbcTemplate.update("DELETE FROM productos WHERE id_producto = ?", new Object[] { id });
	}
	
	
}
