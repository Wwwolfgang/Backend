package com.roshka.springboot.backend.apirest.controllers;

import com.roshka.springboot.backend.apirest.models.entity.BolsaPuntos;
import com.roshka.springboot.backend.apirest.models.services.ICargaPuntoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BolsaRestController {

    @Autowired
    private ICargaPuntoService iCargaPuntoService;

    @PostMapping("/{id}/{monto}")
    @ResponseStatus(HttpStatus.CREATED) // En este caso queremos que devuelva CREATED
    public BolsaPuntos create(@PathVariable String monto, @PathVariable String id) {
        return iCargaPuntoService.save(id,monto);
    }
}
