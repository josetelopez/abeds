package com.peretecorporate.abedsbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peretecorporate.abedsbackend.model.Estado;
import com.peretecorporate.abedsbackend.repository.IEstadoRepository;

@Service
public class EstadoServiceImpl implements EstadoService {

	@Autowired
	private IEstadoRepository estadoRepository;

	@Override
	public List<Estado> findAll() {
		return estadoRepository.findAll();
	}

	@Override
	public Estado getEstadoBycodEstado(int codEstado) {	
		return estadoRepository.getEstadoBycodEstado(codEstado);
	}

	@Override
	public Estado getEstadoBynombreEstado(String nombreEstado) {	
		return estadoRepository.getEstadoBynombreEstado(nombreEstado);
	}

	@Override
	public List<String> getnombreEstados() {
		return estadoRepository.getnombreEstados();
	}

	@Override
	public void delete(Estado estado) {
		estadoRepository.delete(estado);
	}

	@Override
	public void save(Estado estado) {
		estadoRepository.save(estado);
	}
}
