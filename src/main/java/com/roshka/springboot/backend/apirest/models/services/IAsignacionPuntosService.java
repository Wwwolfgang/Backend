package com.roshka.springboot.backend.apirest.models.services;

import java.math.BigDecimal;
import java.util.List;

import com.roshka.springboot.backend.apirest.models.entity.AsignacionPuntos;
import org.springframework.transaction.annotation.Transactional;

public interface IAsignacionPuntosService {
	
	public List<AsignacionPuntos> findAll();
	
	public AsignacionPuntos findById(Long id);
	
	public AsignacionPuntos save(AsignacionPuntos asignacionPuntos);
	
	public void delete(Long id);


    @Transactional(readOnly = true)
    public Integer puntosEquivalente(String monto);
}
