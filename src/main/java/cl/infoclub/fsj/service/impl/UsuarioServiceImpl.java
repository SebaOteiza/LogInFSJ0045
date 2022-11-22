package cl.infoclub.fsj.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import cl.infoclub.fsj.LogInFsj0045Application;
import cl.infoclub.fsj.dao.UsuarioRepo;
import cl.infoclub.fsj.modelo.Usuario;
import cl.infoclub.fsj.service.IUsuarioService;
import cl.infoclub.fsj.vo.UsuarioVO;

public class UsuarioServiceImpl implements IUsuarioService {
	private static final Logger log = LoggerFactory.getLogger(LogInFsj0045Application.class);

	@Autowired
	UsuarioRepo dao;
	UsuarioVO respuesta;

	@Override
	@Transactional(readOnly = true)
	public UsuarioVO findByNombreAndClave(String nombre, String clave) {
		respuesta = new UsuarioVO("Ha ocurrido un error", "101", new ArrayList<Usuario>());
		try {
			List<Usuario> usuarios = dao.findByNombreAndClave(nombre, clave);
			if (usuarios.size() > 0) {
				respuesta.setUsuarios(usuarios);
				respuesta.setMensaje("Usuario encontrado correctamente.");
				respuesta.setCodigo("0");
			} else {
				respuesta.setMensaje("Usuario no encontrado.");
			}
		} catch (Exception e) {
			log.trace("Usuario Service: Error en findByNombreAndClave", e);
		}
		return respuesta;
	}

	@Override
	@Transactional(readOnly = true)
	public UsuarioVO getAllUsuarios() {

		respuesta = new UsuarioVO("Ha ocurrido un error", "102", new ArrayList<Usuario>());
		try {
			respuesta.setUsuarios((List<Usuario>) dao.findAll());
			respuesta.setMensaje(String.format("Se ha/n encontrado %d registro/s", respuesta.getUsuarios().size()));
			respuesta.setCodigo("0");
		} catch (Exception e) {
			log.trace("Usuario Service: Error en getAllUsuarios", e);
		}
		return respuesta;
	}

	@Override
	@Transactional(readOnly = true)
	public UsuarioVO login(String nombre, String clave) {
		respuesta = new UsuarioVO("Credenciales incorrectas", "103", new ArrayList<Usuario>());
		if (nombre.length() == 0 || clave.length() == 0)
			return respuesta;
		respuesta = findByNombreAndClave(nombre, clave);
		if (respuesta.getCodigo().equals("0")) {
			respuesta.setMensaje(String.format("Bienvenido %s", respuesta.getUsuarios().get(0).getNombre()));
		}
		return respuesta;
	}

	@Override
	@Transactional
	public UsuarioVO add(Usuario usuario) {
		respuesta = new UsuarioVO("Ha ocurrido un error", "104", new ArrayList<Usuario>());
		try {
			dao.save(usuario);
			respuesta.setMensaje(String.format("Se ha guardado correctamente al usuario %s", usuario.getNombre()));
			respuesta.setCodigo("0");
		} catch (Exception e) {
			log.trace("Usuario Service: Error en add", e);
		}
		return respuesta;
	}

	@Override
	@Transactional
	public UsuarioVO update(Usuario usuario) {
		respuesta = new UsuarioVO("Ha ocurrido un error", "105", new ArrayList<Usuario>());
		try {
			dao.save(usuario);
			respuesta.setMensaje(String.format("Se ha actualizado correctamente al usuario %s", usuario.getNombre()));
			respuesta.setCodigo("0");
		} catch (Exception e) {
			log.trace("Usuario Service: Error en update", e);
		}
		return respuesta;
	}

	@Override
	@Transactional
	public UsuarioVO delete(Usuario usuario) {
		respuesta = new UsuarioVO("Ha ocurrido un error", "106", new ArrayList<Usuario>());
		try {
			dao.delete(usuario);
			respuesta.setMensaje("Se ha eliminado correctamente al usuario");
			respuesta.setCodigo("0");
		} catch (Exception e) {
			log.trace("Usuario Service: Error en delete", e);
		}
		return respuesta;
	}

	@Override
	@Transactional(readOnly = true)
	public UsuarioVO findById(Integer id) {
		respuesta = new UsuarioVO("Ha ocurrido un error", "107", new ArrayList<Usuario>());
		try {
			Usuario usuario = dao.findById(id).get();
			respuesta.getUsuarios().add(usuario);
			respuesta.setMensaje("Usuario encontrado correctamente.");
			respuesta.setCodigo("0");
		} catch (Exception e) {
			log.trace("Usuario Service: Error en findByNombreAndClave", e);
		}
		return respuesta;
	}
}
