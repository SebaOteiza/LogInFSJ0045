package cl.infoclub.fsj;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import cl.infoclub.fsj.dao.UsuarioRepo;
import cl.infoclub.fsj.modelo.Usuario;

@SpringBootApplication
public class LogInFsj0045Application {
	private static final Logger log = LoggerFactory.getLogger(LogInFsj0045Application.class);

	public static void main(String[] args) {
		SpringApplication.run(LogInFsj0045Application.class, args);
	}

	@Bean
	public CommandLineRunner demo(UsuarioRepo repo) {
		return (args) -> {
			// agregamos dos usuarios
			repo.save(new Usuario(4678, "Rosa", "Espinoza", "Las espinas 20", "lamaravillosa", 15670721, "k",
					"Turositacariñosa"));
			repo.save(new Usuario(6543, "Peter", "Veneno", "Ponzoña 21", "PeterVen", 23456754, "3", "Peter21"));
			// leemos todos los usuarios
			log.info("Lista de usuarios");
			for (Usuario usuario : repo.findAll()) {
				log.info(usuario.toString());
			}
		};

	}
}
