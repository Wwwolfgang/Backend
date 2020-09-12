package com.roshka.springboot.backend.apirest.models.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="bolsas")
public class BolsaPuntos implements Serializable {

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	@Column(name="fechaAsignacion")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date fechaAsignacion;

	@Column(name="fechaCaducidad")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date fechaCaducidad;

	private Integer puntosAsignados;
	private Integer puntosUsados;
	private Integer saldoPuntos;
	private BigDecimal montoOperacion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getFechaAsignacion() {
		return fechaAsignacion;
	}

	public void setFechaAsignacion(Date fechaAsignacion) {
		this.fechaAsignacion = fechaAsignacion;
	}

	public Date getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(Date fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	public Integer getPuntosAsignados() {
		return puntosAsignados;
	}

	public void setPuntosAsignados(Integer puntosAsignados) {
		this.puntosAsignados = puntosAsignados;
	}

	public Integer getPuntosUsados() {
		return puntosUsados;
	}

	public void setPuntosUsados(Integer puntosUsados) {
		this.puntosUsados = puntosUsados;
	}

	public Integer getSaldoPuntos() {
		return saldoPuntos;
	}

	public void setSaldoPuntos(Integer saldoPuntos) {
		this.saldoPuntos = saldoPuntos;
	}

	public BigDecimal getMontoOperacion() {
		return montoOperacion;
	}

	public void setMontoOperacion(BigDecimal montoOperacion) {
		this.montoOperacion = montoOperacion;
	}

	@Column(name="create_at")
	@JsonFormat(pattern="yyyy-MM-dd")
    private Date createAt;

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	private static final long serialVersionUID = 1L;

}
