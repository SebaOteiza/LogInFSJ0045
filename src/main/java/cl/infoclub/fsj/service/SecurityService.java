package cl.infoclub.fsj.service;

import cl.infoclub.fsj.modelo.Usuario;

public interface SecurityService {
	public boolean isLoggedIn();
	public void setUsuarioConectado(Usuario usuario);
	public Usuario getUsuarioConectado();
}