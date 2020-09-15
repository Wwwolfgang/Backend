package com.roshka.springboot.backend.apirest.controllers;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roshka.springboot.backend.apirest.models.entity.Cliente;
import com.roshka.springboot.backend.apirest.models.services.IClienteService;

@RestController
@RequestMapping("/api/reportes")
public class ReportesRestController {
	
	@Autowired
	private IClienteService clienteservice;
    
    
    @GetMapping(value ="/cliente/nombre/{nombre}")
	public List<Cliente> clienteNombre(@PathVariable String nombre){
		return clienteservice.findByNombre(nombre);
	}
    
    @GetMapping(value ="/cliente/apellido/{apellido}")
	public List<Cliente> clienteApellido(@PathVariable String apellido){
		return clienteservice.findByApellido(apellido);
	}
    
    @GetMapping(value ="/cliente/nacimiento/{createAt}")
	public List<Cliente> clienteNacimiento(@PathVariable @DateTimeFormat(pattern="yyyy-MM-dd") Date createAt){
		return clienteservice.findByCreateAt(createAt);
	}
   
   

}
