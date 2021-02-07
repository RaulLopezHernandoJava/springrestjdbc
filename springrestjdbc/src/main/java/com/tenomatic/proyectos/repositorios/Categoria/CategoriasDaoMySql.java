package com.tenomatic.proyectos.repositorios.Categoria;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.tenomatic.proyectos.entidades.Categoria;
import com.tenomatic.proyectos.repositorios.Dao;

@Repository
public class CategoriasDaoMySql implements Dao<Categoria>{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private DataSource dataSource;

	// Obtener todos los productos FUNCIONANDO

	public Iterable<Categoria> obtenerTodos() {

		return jdbcTemplate.query("SELECT * FROM categorias",
				(rs, rowNum) -> new Categoria(rs.getLong("id_categoria"), rs.getString("descripcion")));

	}
	// Obtener categoria por Id FUNCIONANDO
	@Override
	public Categoria obtenerPorId(Long id) {
		return jdbcTemplate.queryForObject("select * from categorias c where c.id_categoria = ?",
				(rs, rowNum) -> new Categoria(rs.getLong("c.id_categoria"), rs.getString("c.descripcion")),id);

	}

	// Insertar categoria FUNCIONANDO
	@Override
	public Categoria insertar(Categoria categoria) {
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("categorias")
				.usingGeneratedKeyColumns("id");
		Map<String, Object> parameters = new HashMap<>(1);

		parameters.put("descripcion", categoria.getDescripcion());

		Long newId = simpleJdbcInsert.executeAndReturnKey(parameters).longValue();
		categoria.setId(newId);

		return categoria;
	}

	// Edita categoria FUNCIONANDO
	@Override
	public Categoria editar(Categoria categoria) {
		jdbcTemplate.update(
				"UPDATE categorias SET descripcion = ? WHERE id_categoria = ?",
				new Object[] { categoria.getDescripcion(),categoria.getId() });
		return categoria;
	}

	// Eliminar categoria funcionando
	@Override
	public void borrar(Long id) {
		jdbcTemplate.update("DELETE FROM categorias WHERE id_categoria = ?", new Object[] { id });
	}


}
