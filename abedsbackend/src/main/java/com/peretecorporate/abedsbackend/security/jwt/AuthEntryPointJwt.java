package com.peretecorporate.abedsbackend.security.jwt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class AuthEntryPointJwt implements AuthenticationEntryPoint {

	private static final Logger logger = LoggerFactory.getLogger(AuthEntryPointJwt.class);
	

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
				AuthenticationException authException) throws IOException, ServletException {
		
		if(authException instanceof org.springframework.security.authentication.BadCredentialsException)
		{			
			logger.error("Bad Credential", authException.getMessage());
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Nombre de usuario o contraseña incorrecta");
		}else
		{	
			logger.error("Unauthorized error: {}", authException.getMessage());
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Error: No autorizado");
		}
	
	}

}
