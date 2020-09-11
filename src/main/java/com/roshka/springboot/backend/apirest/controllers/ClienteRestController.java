package com.roshka.springboot.backend.apirest.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.roshka.springboot.backend.apirest.models.entity.Cliente;
import com.roshka.springboot.backend.apirest.models.services.IClienteService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ClienteRestController {
	
	@Autowired
	private IClienteService clienteservice;
	
	
	@GetMapping("/clientes")
	public List<Cliente> index(){
		return clienteservice.findAll();
	}
	
	
	// @ResponseStatus(HttpStatus.OK) por defecto devuelve 200 Ok
	@GetMapping("/clientes/{id}")
	public Cliente show(@PathVariable Long id){
		return clienteservice.findById(id);
	}
	
	@PostMapping("/clientes")
	@ResponseStatus(HttpStatus.CREATED) // En este caso queremos que devuelva CREATED
	public Cliente create(@RequestBody Cliente cliente) {
		return clienteservice.save(cliente);
	}
	
	@PutMapping("/clientes/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente update(@RequestBody Cliente cliente, @PathVariable Long id) {
		
		Cliente clienteActual = clienteservice.findById(id);
		
		clienteActual.setApellido(cliente.getApellido());
		clienteActual.setNombre(cliente.getNombre());
		clienteActual.setEmail(cliente.getEmail());
		clienteActual.setNacionalidad(cliente.getNacionalidad());
		clienteActual.setTelefono(cliente.getTelefono());
		clienteActual.setNumero_doc(cliente.getNumero_doc());
		clienteActual.setTipo_doc(cliente.getTipo_doc());
		clienteActual.setCreateAt(cliente.getCreateAt());
		
		return clienteservice.save(clienteActual);
	}
	
	@DeleteMapping("/clientes/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		clienteservice.delete(id);
	}

}
