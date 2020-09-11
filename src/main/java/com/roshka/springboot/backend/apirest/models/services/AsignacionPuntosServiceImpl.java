package com.roshka.springboot.backend.apirest.models.services;

import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.roshka.springboot.backend.apirest.models.dao.IAsignacionPuntosDao;
import com.roshka.springboot.backend.apirest.models.entity.AsignacionPuntos;


@Service
public class AsignacionPuntosServiceImpl implements IAsignacionPuntosService{

	@Autowired
	private IAsignacionPuntosDao asignacionPuntosDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<AsignacionPuntos> findAll() {
		return (List<AsignacionPuntos>)asignacionPuntosDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public AsignacionPuntos findById(Long id) {
		return asignacionPuntosDao.findById(id).orElseThrow(null);
	}

	@Override
	@Transactional
	public AsignacionPuntos save(AsignacionPuntos asignacionPuntos) {
		return asignacionPuntosDao.save(asignacionPuntos);
	}

	@Override
	public void delete(Long id) {
		asignacionPuntosDao.deleteById(id);
		
	}
	
	

}
