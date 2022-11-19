package cl.infoclub.fsj.VO;

import java.util.List;

import cl.infoclub.fsj.modelo.Usuario;

public class UsuarioVO {
	List<Usuario> usuarios;
	String mensaje;
	String codigo;
	
	public UsuarioVO() {
		super();
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	public UsuarioVO(List<Usuario> usuarios, String mensaje, String codigo)
	{
	super();
	this.usuarios = usuarios;
	this.mensaje = mensaje;
	this.codigo = codigo;
	}
	public List<Usuario> getUsuarios() {
	return usuarios;
}
	@Override
	public String toString() {
	return "UsuarioVO [mensaje=" + mensaje + ", codigo=" + codigo + "]";
}
}
