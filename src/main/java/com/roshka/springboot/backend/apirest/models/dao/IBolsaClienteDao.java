package com.roshka.springboot.backend.apirest.models.dao;

import org.springframework.data.repository.query.Param;
import com.roshka.springboot.backend.apirest.models.entity.BolsaPuntos;
import org.springframework.data.repository.CrudRepository;

public interface IBolsaClienteDao extends CrudRepository<BolsaPuntos,Long> {

    public BolsaPuntos findByCliente(@Param("cliente") Long cliente);

}
