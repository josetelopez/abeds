package com.peretecorporate.abedsbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peretecorporate.abedsbackend.model.Estado;
import com.peretecorporate.abedsbackend.model.TipoUsuario;
import com.peretecorporate.abedsbackend.repository.ITipoUsuarioRepository;

@Service
public class TipoUsuarioServiceImpl implements TipoUsuarioService {

	@Autowired
	private ITipoUsuarioRepository tipoUsuarioRepository;

	@Override
	public List<TipoUsuario> findAll() {
		return tipoUsuarioRepository.findAll();
	}

	@Override
	public TipoUsuario findByidTipoUsuario(Integer id) {
		return tipoUsuarioRepository.findByidTipoUsuario(id);
	}

	@Override
	public TipoUsuario findBytipoUsuario(String tipoUsuario) {
		return tipoUsuarioRepository.findBytipoUsuario(tipoUsuario);
	}

	@Override
	public TipoUsuario findByCodTipoUsuario(String codTipoUsuario) {
		return tipoUsuarioRepository.findByCodTipoUsuario(codTipoUsuario);
	}

	@Override
	public List<String> getAllBytipoUsuario() {
		return tipoUsuarioRepository.getAllBytipoUsuario();
	}

	@Override
	public List<String> getAllBycodTipoUsuario() {
		return tipoUsuarioRepository.getAllBycodTipoUsuario();
	}

	@Override
	public void delete(TipoUsuario tipoUsuario) {
		tipoUsuarioRepository.delete(tipoUsuario);
	}

	@Override
	public void save(TipoUsuario tipoUsuario) {
		tipoUsuarioRepository.save(tipoUsuario);
	}
}
