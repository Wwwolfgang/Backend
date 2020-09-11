package com.roshka.springboot.backend.apirest.models.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "asignacionpuntos")
public class AsignacionPuntos implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "limite_inferior")
	private BigDecimal limiteInferior;

	@Column(name = "limite_superior")
	private BigDecimal limiteSuperior;

	@Column(name = "monto_equivalente")
	private BigDecimal montoEquivalente;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getLimiteInferior() {
		return limiteInferior;
	}

	public void setLimiteInferior(BigDecimal limiteInferior) {
		this.limiteInferior = limiteInferior;
	}

	public BigDecimal getLimiteSuperior() {
		return limiteSuperior;
	}

	public void setLimiteSuperior(BigDecimal limiteSuperior) {
		this.limiteSuperior = limiteSuperior;
	}

	public BigDecimal getMontoEquivalente() {
		return montoEquivalente;
	}

	public void setMontoEquivalente(BigDecimal montoEquivalente) {
		this.montoEquivalente = montoEquivalente;
	}

	private static final long serialVersionUID = 1L;

}
