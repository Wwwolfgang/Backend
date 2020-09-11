package com.roshka.springboot.backend.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.roshka.springboot.backend.apirest.models.entity.UsoPuntos;
import com.roshka.springboot.backend.apirest.models.services.IUsoPuntosService;

@RestController
@RequestMapping("/api")
public class UsoPuntosRestController {

	
	@Autowired
	private IUsoPuntosService usopuntosservice;
	
	
	@GetMapping("/uso-puntos")
	public List<UsoPuntos> index(){
		return usopuntosservice.findAll();
	}
	
	@GetMapping("/uso-puntos/{id}")
	public UsoPuntos show(@PathVariable Long id){
		return usopuntosservice.findById(id);
	}
	
	@PostMapping("/uso-puntos")
	@ResponseStatus(HttpStatus.CREATED) // En este caso queremos que devuelva CREATED
	public UsoPuntos create(@RequestBody UsoPuntos usoPuntos) {
		return usopuntosservice.save(usoPuntos);
	}
	
	@PutMapping("/uso-puntos/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public UsoPuntos update(@RequestBody UsoPuntos usoPuntos, @PathVariable Long id) {
		
		UsoPuntos usoPuntosActual = usopuntosservice.findById(id);
		
		usoPuntosActual.setDescripcionPuntos(usoPuntos.getDescripcionPuntos());
		usoPuntosActual.setPuntosRequeridos(usoPuntos.getPuntosRequeridos());
		
		return usopuntosservice.save(usoPuntosActual);
	}
	
	@DeleteMapping("/uso-puntos/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		usopuntosservice.delete(id);
	}
}
