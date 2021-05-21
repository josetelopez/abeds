package com.peretecorporate.abedsbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.peretecorporate.abedsbackend.model.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer>{

}
