package com.peretecorporate.abedsbackend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.peretecorporate.abedsbackend.model.Estado;

@Service
public interface EstadoService {

	List<Estado> findAll();

	Estado getEstadoBycodEstado(int codEstado);

	Estado getEstadoBynombreEstado(String nombreEstado);

	List<String> getnombreEstados();

	void delete(Estado estado);
	
	void save(Estado estado);
}
