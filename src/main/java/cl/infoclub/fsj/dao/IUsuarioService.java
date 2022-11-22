package cl.infoclub.fsj.dao;

import cl.infoclub.fsj.modelo.Usuario;
import cl.infoclub.fsj.vo.UsuarioVO;

public interface IUsuarioService {
	public UsuarioVO getAllUsuarios();
	 public UsuarioVO findByNombreAndClave(String nombre, String clave);
	 public UsuarioVO login(String nombre, String clave);
	 public UsuarioVO add(Usuario usuario);
	 public UsuarioVO update(Usuario usuario);
	 public UsuarioVO delete(Usuario usuario);
	 public UsuarioVO findById(Integer id);
}
