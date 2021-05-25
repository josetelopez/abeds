package com.peretecorporate.abedsbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peretecorporate.abedsbackend.repository.ITipoUsuarioRepository;

@Service
public class TipoUsuarioService {

	@Autowired
	private ITipoUsuarioRepository tipoUsuarioRepository;
}
