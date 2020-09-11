package com.roshka.springboot.backend.apirest.models.services;

import com.roshka.springboot.backend.apirest.models.entity.BolsaPuntos;

import java.util.List;

public interface ICargaPuntoService {

    public List<BolsaPuntos> findAll();

    public BolsaPuntos findById(Long id);

    public BolsaPuntos save(String id, String monto); // recibe un objeto cliente y retorna un cliente ya con el id

    public void delete(Long id);
}
