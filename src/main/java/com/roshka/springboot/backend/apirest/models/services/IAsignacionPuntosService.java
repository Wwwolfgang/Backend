package com.roshka.springboot.backend.apirest.models.services;

import java.util.List;

import com.roshka.springboot.backend.apirest.models.entity.AsignacionPuntos;

public interface IAsignacionPuntosService {
	
	public List<AsignacionPuntos> findAll();
	
	public AsignacionPuntos findById(Long id);
	
	public AsignacionPuntos save(AsignacionPuntos asignacionPuntos);
	
	public void delete(Long id);
	
	
}
