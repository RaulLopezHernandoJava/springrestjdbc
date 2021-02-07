package com.tenomatic.proyectos.repositorios.Proveedor;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.tenomatic.proyectos.entidades.Proveedor;
import com.tenomatic.proyectos.repositorios.Dao;

@Repository
public class ProveedoresDaoMySql implements Dao<Proveedor> {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private DataSource dataSource;

	// Obtener todos los proveedores FUNCIONANDO

	public Iterable<Proveedor> obtenerTodos() {

		return jdbcTemplate.query("SELECT * FROM proveedores", (rs, rowNum) -> new Proveedor(rs.getLong("id_proveedor"),
				rs.getString("nombre"), rs.getString("direccion"), rs.getString("telefono")));

	}

	// Obtener proveedores por Id FUNCIONANDO
	@Override
	public Proveedor obtenerPorId(Long id) {
		return jdbcTemplate.queryForObject("select * from proveedores p where p.id_proveedor = ?",
				(rs, rowNum) -> new Proveedor(rs.getLong("p.id_proveedor"), rs.getString("p.nombre"),
						rs.getString("p.direccion"), rs.getString("p.telefono")),
				id);

	}

	// Insertar proveedor FUNCIONANDO
	@Override
	public Proveedor insertar(Proveedor proveedor) {
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("proveedores")
				.usingGeneratedKeyColumns("id");
		Map<String, Object> parameters = new HashMap<>(1);

		parameters.put("nombre", proveedor.getNombre());
		parameters.put("direccion", proveedor.getDireccion());
		parameters.put("telefono", proveedor.getTelefono());

		Long newId = simpleJdbcInsert.executeAndReturnKey(parameters).longValue();
		proveedor.setId(newId);

		return proveedor;
	}

	// Edita Producto FUNCIONANDO
	@Override
	public Proveedor editar(Proveedor proveedor) {
		jdbcTemplate.update("UPDATE proveedor SET nombre = ?, direccion = ?, telefono = ? WHERE id_proveedor = ?",
				new Object[] { proveedor.getNombre(), proveedor.getDireccion(), proveedor.getTelefono(),
						proveedor.getId() });
		return proveedor;
	}

	// Eliminar producto funcionando
	@Override
	public void borrar(Long id) {
		jdbcTemplate.update("DELETE FROM proveedor WHERE id_proveedor = ?", new Object[] { id });
	}
}
