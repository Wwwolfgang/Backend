package com.roshka.springboot.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.roshka.springboot.backend.apirest.models.entity.UsoPuntos;

public interface IUsoPuntosDao extends CrudRepository<UsoPuntos, Long>{

}
