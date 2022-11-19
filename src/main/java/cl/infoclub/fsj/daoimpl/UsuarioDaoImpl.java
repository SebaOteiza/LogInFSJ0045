package cl.infoclub.fsj.daoimpl;

import java.util.List;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cl.infoclub.fsj.dao.IUsuarioDao;
import cl.infoclub.fsj.mapper.UsuarioMapper;
import cl.infoclub.fsj.modelo.Usuario;

@Repository
public class UsuarioDaoImpl implements IUsuarioDao {
	
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	public UsuarioDaoImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		
		
	}
	
	

	@Override
	public List<Usuario> getAllUsuarios() {
		
		return jdbcTemplate.query("select * from Usuario", new UsuarioMapper());
		
	}

	@Override
	public Usuario getUsuarioById(int id) {
		
		return (Usuario) jdbcTemplate.query("select * from Usuario where id =?", new UsuarioMapper());
	}

}
