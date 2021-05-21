package com.peretecorporate.abedsbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Import;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@Import(SwaggerConfiguration.class)
public class AbedsbackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(AbedsbackendApplication.class, args);
	}

}
