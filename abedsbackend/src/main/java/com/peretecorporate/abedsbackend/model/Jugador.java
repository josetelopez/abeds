package com.peretecorporate.abedsbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "abedsd_jugador")
public class Jugador {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id_jugador", unique = true, nullable = false)
	private Integer		idJugador;

	@OneToOne
	@JoinColumn(name = "id_usuario")
	private Usuario		usuario;

	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private Categoria	categoria;

	@Column(name = "dorsal", length = 2)
	private int			dorsal;

	@ManyToOne
	@JoinColumn(name = "id_equipo")
	private Equipo		equipo;

	@ManyToOne
	@JoinColumn(name = "id_estado")
	private Estado		estado;

	/**
	 * Getters and Setter
	 */

	public Integer getIdJugador() {
		return idJugador;
	}

	public void setIdJugador(Integer idJugador) {
		this.idJugador = idJugador;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

}
