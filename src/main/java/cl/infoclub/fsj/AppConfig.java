package cl.infoclub.fsj;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("cl.infoclub.fsj")
@PropertySource("classpath:database.properties")
public class AppConfig {
	
	@Autowired
	Environment environment;
	
	@Bean
	DataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		System.out.println("Aqui parte la conexion");
		driverManagerDataSource.setUrl(environment.getProperty("url"));
		System.out.println("traje la URL");
		driverManagerDataSource.setUsername(environment.getProperty("dbuser"));
		System.out.println("traje user");
		driverManagerDataSource.setPassword(environment.getProperty("dbpassword"));
		System.out.println("Traje password");
		driverManagerDataSource.setDriverClassName(environment.getProperty("driver"));
		System.out.println("traje driver");
		return driverManagerDataSource;
		
	}

}
