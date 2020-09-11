package com.roshka.springboot.backend.apirest.models.services;

import java.util.List;

import com.roshka.springboot.backend.apirest.models.entity.UsoPuntos;

public interface IUsoPuntosService {
	
	public List<UsoPuntos> findAll();
	
	public UsoPuntos findById(Long id);
	
	public UsoPuntos save(UsoPuntos usoPuntos);
	
	public void delete(Long id);

}
