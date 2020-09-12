package com.roshka.springboot.backend.apirest.controllers;

import com.roshka.springboot.backend.apirest.models.entity.BolsaPuntos;
import com.roshka.springboot.backend.apirest.models.entity.Cabecera;
import com.roshka.springboot.backend.apirest.models.services.ICabeceraService;
import com.roshka.springboot.backend.apirest.models.services.ICargaPuntoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BolsaRestController {

    @Autowired
    private ICargaPuntoService iCargaPuntoService;

    @Autowired
    private ICabeceraService cabeceraService;

    @PostMapping("/compra/{id}/{monto}")
    @ResponseStatus(HttpStatus.CREATED) // En este caso queremos que devuelva CREATED
    public BolsaPuntos create(@PathVariable String monto, @PathVariable String id) {
        return iCargaPuntoService.save(id,monto);
    }


    @PostMapping("/utilizar/{id_cliente}/{id_concepto}")
    @ResponseStatus(HttpStatus.CREATED)
    public String crear(@PathVariable String id_cliente, @PathVariable String id_concepto){
        return cabeceraService.save(id_cliente,id_concepto);
    }
}
