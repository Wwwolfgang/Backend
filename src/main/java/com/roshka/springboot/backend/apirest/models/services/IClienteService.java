package com.roshka.springboot.backend.apirest.models.services;

import java.util.List;

import com.roshka.springboot.backend.apirest.models.entity.Cliente;

public interface IClienteService {
	
	public List<Cliente> findAll();
	
	public Cliente findById(Long id);
	
	public Cliente save(Cliente cliente); // recibe un objeto cliente y retorna un cliente ya con el id
	
	public void delete(Long id);

	public List<Cliente> findByNombre(String nombre);
	
	public List<Cliente> findByApellido(String apellido);
	
	public List<Cliente> findByCreateAt(Date createAt);
	
	
}
