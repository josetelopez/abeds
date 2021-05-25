package com.peretecorporate.abedsbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.peretecorporate.abedsbackend.model.TipoUsuario;

public interface ITipoUsuarioRepository extends JpaRepository<TipoUsuario, Integer> {

}
