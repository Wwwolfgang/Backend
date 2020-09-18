package com.roshka.springboot.backend.apirest.models.services;

import java.util.List;
import java.util.Date;
import com.roshka.springboot.backend.apirest.models.entity.Cliente;
import com.roshka.springboot.backend.apirest.models.entity.BolsaPuntos;

public interface IBolsaService {
	
	public BolsaPuntos findByCliente(Long cliente);
	
	public List<BolsaPuntos> findAll();
}
