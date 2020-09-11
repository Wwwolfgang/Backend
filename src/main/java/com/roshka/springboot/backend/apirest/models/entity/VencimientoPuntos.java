package com.roshka.springboot.backend.apirest.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "vencimientopuntos")
public class VencimientoPuntos implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "fecha_inicio")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date fechaInicio;

	@Column(name = "fecha_fin")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date fechaFin;

	@Column(name = "dias_duracion")
	private Double diasDuracion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Double getDiasDuracion() {
		return diasDuracion;
	}

	public void setDiasDuracion(Double diasDuracion) {
		this.diasDuracion = diasDuracion;
	}

	private static final long serialVersionUID = 1L;

}
