package cl.infoclub.fsj.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cl.infoclub.fsj.LogInFsj0045Application;
import cl.infoclub.fsj.modelo.Usuario;
import cl.infoclub.fsj.service.SecurityService;
import cl.infoclub.fsj.service.impl.UsuarioServiceImpl;
import cl.infoclub.fsj.vo.UsuarioVO;

@Controller
public class SecurityController {
	private static final Logger log = LoggerFactory.getLogger(LogInFsj0045Application.class);
	@Autowired
	private UsuarioServiceImpl usrSvc;
	@Autowired
	private SecurityService secSvc;

	@GetMapping({ "/", "/login" })
	public String login(Model model) {
		return secSvc.isLoggedIn() ? "redirect:/home" : "login";
	}

	@PostMapping({ "/handleLogin" })
	public ModelAndView handleLogin(@ModelAttribute Usuario usuario, RedirectAttributes ra) {
		UsuarioVO respuestaServicio = usrSvc.login(usuario.getNombre(), usuario.getClave());
		log.info(String.format("Consultando por usuario autenticado (%s)", respuestaServicio));
		ra.addFlashAttribute("mensaje", respuestaServicio.getMensaje());
		if (respuestaServicio.getCodigo().equals("0")) {
			secSvc.setUsuarioConectado(respuestaServicio.getUsuarios().get(0));
			return new ModelAndView("redirect:/home");
		} else {
			return new ModelAndView("redirect:/login");
		}
	}

	@PostMapping({ "/handleLogout" })
	public String handleLogout(@ModelAttribute Usuario usuario, RedirectAttributes ra) {
		secSvc.setUsuarioConectado(null);
		return "redirect:/login";
	}
}
