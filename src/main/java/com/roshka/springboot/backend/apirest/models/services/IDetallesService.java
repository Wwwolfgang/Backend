package com.roshka.springboot.backend.apirest.models.services;

import com.roshka.springboot.backend.apirest.models.entity.BolsaPuntos;
import com.roshka.springboot.backend.apirest.models.entity.Detalle;

import java.util.List;

public interface IDetallesService {
    public List<Detalle> findAll();

    public Detalle findById(Long id);

    public Detalle save(Detalle detalle);
}
