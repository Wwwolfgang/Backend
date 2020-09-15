package com.roshka.springboot.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.roshka.springboot.backend.apirest.models.entity.Cliente;

public interface IClienteDao extends CrudRepository<Cliente , Long>{

	public List<Cliente> findByNombre(@Param("nombre") String nombre);
	
	public List<Cliente> findByApellido(@Param("apellido") String apellido);
	
	public List<Cliente> findByCreateAt(@Param("createAt") Date createAt);

}