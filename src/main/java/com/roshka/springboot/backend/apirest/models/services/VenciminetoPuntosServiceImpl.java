package com.roshka.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.roshka.springboot.backend.apirest.models.dao.IVencimientoPuntosDao;
import com.roshka.springboot.backend.apirest.models.entity.VencimientoPuntos;

@Service
public class VenciminetoPuntosServiceImpl implements IVencimientoPuntosService {

	@Autowired
	private IVencimientoPuntosDao vencimientoPuntosDao;

	@Override
	@Transactional(readOnly = true)
	public List<VencimientoPuntos> findAll() {
		return (List<VencimientoPuntos>)vencimientoPuntosDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public VencimientoPuntos findById(Long id) {
		return vencimientoPuntosDao.findById(id).orElseThrow(null);
	}

	@Override
	@Transactional
	public VencimientoPuntos save(VencimientoPuntos vencimientoPuntos) {
		return vencimientoPuntosDao.save(vencimientoPuntos);
	}

	@Override
	public void delete(Long id) {
		vencimientoPuntosDao.deleteById(id);

	}

}
