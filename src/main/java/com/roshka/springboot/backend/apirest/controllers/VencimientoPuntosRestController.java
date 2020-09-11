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

import com.roshka.springboot.backend.apirest.models.entity.VencimientoPuntos;
import com.roshka.springboot.backend.apirest.models.services.IVencimientoPuntosService;

@RestController
@RequestMapping("/api")
public class VencimientoPuntosRestController {
	
	@Autowired
	private IVencimientoPuntosService vencimientopuntoservice;
	
	@GetMapping("/vencimiento-puntos")
	public List<VencimientoPuntos> index(){
		return vencimientopuntoservice.findAll();
	}
	
	@GetMapping("/vencimiento-puntos/{id}")
	public VencimientoPuntos show(@PathVariable Long id){
		return vencimientopuntoservice.findById(id);
	}
	
	@PostMapping("/vencimiento-puntos")
	@ResponseStatus(HttpStatus.CREATED)
	public VencimientoPuntos create(@RequestBody VencimientoPuntos vencimientoPuntos) {
		return vencimientopuntoservice.save(vencimientoPuntos);
	}
	
	
	@PutMapping("/vencimiento-puntos/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public VencimientoPuntos update(@RequestBody VencimientoPuntos vencimientoPuntos, @PathVariable Long id) {
		
		VencimientoPuntos vencimientoPuntosActual = vencimientopuntoservice.findById(id);
		
		vencimientoPuntosActual.setFechaInicio(vencimientoPuntos.getFechaInicio());
		vencimientoPuntosActual.setFechaFin(vencimientoPuntos.getFechaFin());;
		vencimientoPuntosActual.setDiasDuracion(vencimientoPuntos.getDiasDuracion());;
		
		return vencimientopuntoservice.save(vencimientoPuntosActual);
	}
	
	@DeleteMapping("/vencimiento-puntos/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		vencimientopuntoservice.delete(id);
	}

}
