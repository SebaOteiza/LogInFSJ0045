package cl.infoclub.fsj.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import cl.infoclub.fsj.LogInFsj0045Application;
import cl.infoclub.fsj.modelo.Usuario;
import cl.infoclub.fsj.service.SecurityService;

@SessionScope
@Service
public class SecurityServiceImpl implements SecurityService {
	private static final Logger log = LoggerFactory.getLogger(LogInFsj0045Application.class);
	Usuario usuarioConectado = null;

	@Override
	public boolean isLoggedIn() {
		log.info("Consultando por usuario autenticado");
		return null != this.usuarioConectado;
	}

	@Override
	public Usuario getUsuarioConectado() {
		log.info("Devolviendo al usuario conectado");
		return usuarioConectado;
	}

	@Override
	public void setUsuarioConectado(Usuario usuario) {
		log.info("Estableciendo usuario conectado");
		this.usuarioConectado = usuario;
	}
}