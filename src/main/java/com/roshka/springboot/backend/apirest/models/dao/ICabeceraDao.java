package com.roshka.springboot.backend.apirest.models.dao;

import com.roshka.springboot.backend.apirest.models.entity.Cabecera;
import org.springframework.data.repository.CrudRepository;

public interface ICabeceraDao extends CrudRepository<Cabecera,Long> {
}
