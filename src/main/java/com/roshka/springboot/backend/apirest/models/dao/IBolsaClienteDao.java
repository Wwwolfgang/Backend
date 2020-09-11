package com.roshka.springboot.backend.apirest.models.dao;

import com.roshka.springboot.backend.apirest.models.entity.BolsaPuntos;
import org.springframework.data.repository.CrudRepository;

public interface IBolsaClienteDao extends CrudRepository<BolsaPuntos,Long> {
}
