package cl.infoclub.fsj.dao;

import cl.infoclub.fsj.vo.GenericVO;

public interface IUsuarioVO {
	public GenericVO getAllUsuarios();
	public GenericVO findByNombreAndClave(String nombre, String clave);
}
