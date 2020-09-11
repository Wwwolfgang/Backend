package com.roshka.springboot.backend.apirest.models.services;

import java.util.List;

import com.roshka.springboot.backend.apirest.models.entity.VencimientoPuntos;

public interface IVencimientoPuntosService {
	
	public List<VencimientoPuntos> findAll();
	
	public VencimientoPuntos findById(Long id);
	
	public VencimientoPuntos save(VencimientoPuntos vencimientoPuntos);
	
	public void delete(Long id);

}
