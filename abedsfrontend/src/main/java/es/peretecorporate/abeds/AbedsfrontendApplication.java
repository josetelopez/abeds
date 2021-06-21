package es.peretecorporate.abeds;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Clase para inicilizar la aplicacion frontend de abeds.Primero debe estas desplegado el war de la
 * parte backend.
 * @author jlopez5
 *
 */

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, SecurityAutoConfiguration.class})
public class AbedsfrontendApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(AbedsfrontendApplication.class, args);
	}

}
