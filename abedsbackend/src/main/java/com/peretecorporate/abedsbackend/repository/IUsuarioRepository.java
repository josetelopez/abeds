package com.peretecorporate.abedsbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.peretecorporate.abedsbackend.model.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {

	List<Usuario> findAll();

	Usuario findUsuarioByidUsuario(Integer id);
	
	@Query("Select usu from Usuario usu where usu.nombre like %:nombre% and usu.apellido1 like %:apellido1% and usu.apellido2 like %:apellido2%")
	Usuario findUsuarioByNombre(String nombre, String apellido1, String apellido2);

	@Query("Select usu from Usuario usu where usu.nif = :nif ")
	Usuario findUsuarioBynif(String nif);

	@Query("Select usu from Usuario usu where usu.email = :email")
	Usuario findUsuarioByemail(String email);

	@Query("Select usu from Usuario usu where usu.idTipoUsuario = (Select tusu.idTipoUsuario from TipoUsuario tusu where codTipoUsuario = 'ADMIN')")
	List<Usuario> getListadoUsuariosAdministradores();

	@Query("Select usu from Usuario usu where usu.idTipoUsuario = (Select tusu.idTipoUsuario from TipoUsuario tusu where codTipoUsuario = 'ARB')")
	List<Usuario> getListadoUsuariosArbitros();

	@Query("Select usu from Usuario usu where usu.idTipoUsuario = (Select tusu.idTipoUsuario from TipoUsuario tusu where codTipoUsuario = 'ENT')")
	List<Usuario> getListadoUsuarioEntrenadores();
	
	@Query("Select usu from Usuario usu where usu.idTipoUsuario = (Select tusu.idTipoUsuario from TipoUsuario tusu where codTipoUsuario = 'RES_SEDE')")
	List<Usuario> getListadoUsuarioRespSede();

	void deleteBynif(String nif);
	

}
