package com.roshka.springboot.backend.apirest.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usopuntos")
public class UsoPuntos implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "descripcion_puntos")
	private String descripcionPuntos;

	@Column(name = "puntos_requeridos")
	private Double puntosRequeridos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcionPuntos() {
		return descripcionPuntos;
	}

	public void setDescripcionPuntos(String descripcionPuntos) {
		this.descripcionPuntos = descripcionPuntos;
	}

	public Double getPuntosRequeridos() {
		return puntosRequeridos;
	}

	public void setPuntosRequeridos(Double puntosRequeridos) {
		this.puntosRequeridos = puntosRequeridos;
	}

	private static final long serialVersionUID = 1L;

}
