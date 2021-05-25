package com.peretecorporate.abedsbackend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.peretecorporate.abedsbackend.model.Estado;
import com.peretecorporate.abedsbackend.model.TipoUsuario;

@Service
public interface TipoUsuarioService {

	List<TipoUsuario> findAll();

	TipoUsuario findByidTipoUsuario(Integer id);

	TipoUsuario findBytipoUsuario(String tipoUsuario);

	TipoUsuario findByCodTipoUsuario(String codTipoUsuario);

	List<String> getAllBytipoUsuario();

	List<String> getAllBycodTipoUsuario();

	void delete(TipoUsuario tipoUsuario);
	
	void save(TipoUsuario tipoUsuario);
}
