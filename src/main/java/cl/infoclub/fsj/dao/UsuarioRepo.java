package cl.infoclub.fsj.dao;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import cl.infoclub.fsj.modelo.Usuario;

public interface UsuarioRepo  extends  Repository<Usuario, Integer>, CrudRepository<Usuario, Integer> {

	 @Query("FROM Usuario WHERE nombre = 'Rosa' and clave = 'lamaravillosa'")
	 public List<Usuario> findByNombreAndClave(String nombre, String clave);

}
