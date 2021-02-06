package com.tecnomatic.proyectos.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tenomatic.proyectos.entidades.Producto;

public class ProductoRowMapper implements RowMapper<Producto>{

	@Override
	public Producto mapRow(ResultSet rs, int rowNum) throws SQLException {
		Producto producto = new Producto();
        producto.setId(rs.getLong("id_producto"));
        producto.setDescripcion(rs.getString("descripcion"));
        producto.setPrecio(rs.getInt("precio"));
        producto.setIdProveedor(rs.getLong("idProveedor"));
        producto.setIdCategoria(rs.getLong("idCategoria"));
        return producto;

	}

}
