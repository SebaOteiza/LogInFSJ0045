package cl.infoclub.fsj;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cl.infoclub.fsj.dao.IUsuarioDao;
import cl.infoclub.fsj.modelo.Usuario;

@SpringBootApplication
public class LogInFsj0045Application {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		IUsuarioDao iUsuarioDao = context.getBean(IUsuarioDao.class);
		System.out.println("\nUsuarios:");
		for (Usuario p : iUsuarioDao.getAllUsuarios()) {
			System.out.println(p);
	}
		context.close();

	}
}
