package com.peretecorporate.abedsbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peretecorporate.abedsbackend.model.Equipo;
import com.peretecorporate.abedsbackend.repository.IEquipoRepository;

@Service
public class EquipoServiceImpl implements EquipoService{

	@Autowired
	private IEquipoRepository equipoRepository;

	@Override
	public List<Equipo> findAll() {
		return equipoRepository.findAll();
	}

	@Override
	public List<Equipo> findAllByidCategoria(Integer idCategoria) {
		return null;
	}

	@Override
	public List<Equipo> findAllByidEntrenador(Integer idEntrenador) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Equipo> findAllBynombreEquipo(String nombreEquipo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Equipo> findAllByanno(int anno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Equipo getByidEquipo(Integer idEquipo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Equipo getBynombreEquipo(String nombreEquipo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> findAllNombreEquipo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Equipo equipo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Equipo equipo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteByidEquipo(Integer idEquipo) {
		// TODO Auto-generated method stub
		
	}
}
