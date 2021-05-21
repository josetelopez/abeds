package com.peretecorporate.abedsbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.peretecorporate.abedsbackend.model.Usuario;
import com.peretecorporate.abedsbackend.service.UsuarioService;

@RestController
@RequestMapping("/database")
public class TestController {

	@Autowired
	private UsuarioService usuarioService;

	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	@PostMapping("/usuario")
	public void registrarUser(@RequestBody Usuario usuario) {
		usuarioService.registrar(usuario);
	}

}
