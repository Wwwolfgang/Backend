package com.roshka.springboot.backend.apirest.models.services;

import com.roshka.springboot.backend.apirest.models.entity.Cabecera;

import java.util.List;

public interface ICabeceraService {
    public List<Cabecera> findAll();

    public Cabecera findById(Long id);

    public String save(String id_cliente, String id_concepto);
}
