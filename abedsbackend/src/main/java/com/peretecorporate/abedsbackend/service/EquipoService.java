package com.peretecorporate.abedsbackend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.peretecorporate.abedsbackend.model.Equipo;

@Service
public interface EquipoService {

	List<Equipo> findAll();

	List<Equipo> findAllByidCategoria(Integer idCategoria);
	
	List<Equipo> findAllByidEntrenador(Integer idEntrenador);
	
	List<Equipo> findAllBynombreEquipo(String nombreEquipo);
	
	List<Equipo> findAllByanno(int anno);

	Equipo getByidEquipo(Integer idEquipo);
	
	Equipo getBynombreEquipo(String nombreEquipo);
	
	List<String> findAllNombreEquipo();
	
	void save(Equipo equipo);
	
	void delete(Equipo equipo);
	
	void deleteByidEquipo(Integer idEquipo);
	
}
