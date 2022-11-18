package cl.infoclub.fsj.dao;

import java.util.List;

import cl.infoclub.fsj.modelo.Usuario;

public interface IUsuarioDao {
	
	List<Usuario> getAllUsuarios();
	
	Usuario getUsuarioById(int id);

}
