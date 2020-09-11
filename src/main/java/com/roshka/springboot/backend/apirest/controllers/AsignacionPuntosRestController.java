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

import com.roshka.springboot.backend.apirest.models.entity.AsignacionPuntos;
import com.roshka.springboot.backend.apirest.models.services.IAsignacionPuntosService;

@RestController
@RequestMapping("/api")
public class AsignacionPuntosRestController {
	
	@Autowired
	private IAsignacionPuntosService asignacionpuntoservice;
	
	@GetMapping("/asignacion-puntos")
	public List<AsignacionPuntos> index(){
		return asignacionpuntoservice.findAll();
	}
	
	@GetMapping("/asignacion-puntos/{id}")
	public AsignacionPuntos show(@PathVariable Long id){
		return asignacionpuntoservice.findById(id);
	}
	
	@PostMapping("/asignacion-puntos")
	@ResponseStatus(HttpStatus.CREATED)
	public AsignacionPuntos create(@RequestBody AsignacionPuntos asignacionPuntos) {
		return asignacionpuntoservice.save(asignacionPuntos);
	}
	
	@PutMapping("/asignacion-puntos/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public AsignacionPuntos update(@RequestBody AsignacionPuntos asignacionPuntos, @PathVariable Long id) {
		
		AsignacionPuntos asignacionPuntosActual = asignacionpuntoservice.findById(id);
		
		asignacionPuntosActual.setLimiteInferior(asignacionPuntos.getLimiteInferior());
		asignacionPuntosActual.setLimiteSuperior(asignacionPuntos.getLimiteSuperior());
		asignacionPuntosActual.setMontoEquivalente(asignacionPuntos.getMontoEquivalente());
		
		return asignacionpuntoservice.save(asignacionPuntosActual);
	}
	
	@DeleteMapping("/asignacion-puntos/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		asignacionpuntoservice.delete(id);
	}
	
	
}
