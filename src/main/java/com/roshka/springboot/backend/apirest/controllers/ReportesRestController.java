package com.roshka.springboot.backend.apirest.controllers;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roshka.springboot.backend.apirest.models.entity.BolsaPuntos;
import com.roshka.springboot.backend.apirest.models.entity.Cliente;
import com.roshka.springboot.backend.apirest.models.services.ICabeceraService;
import com.roshka.springboot.backend.apirest.models.services.ICargaPuntoService;
import com.roshka.springboot.backend.apirest.models.services.IClienteService;

@RestController
@RequestMapping("/api/reportes")
public class ReportesRestController {
	
	@Autowired
	private IClienteService clienteservice;
	
	@Autowired
    private ICargaPuntoService iCargaPuntoService;

    @Autowired
    private ICabeceraService cabeceraService;
    
    
    @GetMapping("/cliente/{nombre}")
	public Optional<Cliente> clienteNombre(@PathVariable String nombre){
		return clienteservice.findByNombre(nombre);
	}
    
    @GetMapping("/cliente/{apellido}")
	public Optional<Cliente> clienteApellido(@PathVariable String apellido){
		return clienteservice.findByNombre(apellido);
	}
    
    @GetMapping("/cliente/{nombre}")
	public Optional<Cliente> clienteDate(@PathVariable Date createAt){
		return clienteservice.findByCreateAt(createAt);
	}
    
    GetMapping("/cliente/{nombre}/{apellido}/{createAt}")
	public Optional<Cliente> clienteConsulta(@PathVariable String nombre,@PathVariable String apellido,@PathVariable Date createAt){
		return clienteservice.findByNombreAndApellidoAndCreateAtAllIgnoreCase(nombre, apellido, createAt);
	}
	
	

}
