package com.roshka.springboot.backend.apirest.models.dao;

import com.roshka.springboot.backend.apirest.models.entity.Detalle;
import org.springframework.data.repository.CrudRepository;

public interface IDetalleDao extends CrudRepository<Detalle,Long> {
}
