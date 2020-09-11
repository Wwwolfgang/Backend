package com.roshka.springboot.backend.apirest.models.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.roshka.springboot.backend.apirest.models.dao.IUsoPuntosDao;
import com.roshka.springboot.backend.apirest.models.entity.UsoPuntos;

@Service
public class UsoPuntosServiceImpl implements IUsoPuntosService{

	@Autowired
	private IUsoPuntosDao usoPuntosDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<UsoPuntos> findAll() {
		return (List<UsoPuntos>) usoPuntosDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public UsoPuntos findById(Long id) {
		return usoPuntosDao.findById(id).orElseThrow(null);
	}

	@Override
	@Transactional
	public UsoPuntos save(UsoPuntos usoPuntos) {
		return usoPuntosDao.save(usoPuntos);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		usoPuntosDao.deleteById(id);
		
	}

}
