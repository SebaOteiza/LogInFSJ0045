package cl.infoclub.fsj.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cl.infoclub.fsj.modelo.Usuario;

public class UsuarioMapper implements RowMapper<Usuario> {
	
	public Usuario mapRow(ResultSet resultSet, int i) throws SQLException{
		Usuario usuario = new Usuario();
		usuario.setId(resultSet.getInt("id"));
		usuario.setNombre(resultSet.getString("nombre"));
		usuario.setApellido(resultSet.getString("apellido"));
		usuario.setClave(resultSet.getString("clave"));
		usuario.setRut(resultSet.getInt("rut"));
		usuario.setDv(resultSet.getString("dv"));
		usuario.setUsuario(resultSet.getString("usuario"));
		
		return usuario;
	}

	
}
