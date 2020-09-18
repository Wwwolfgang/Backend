package com.roshka.springboot.backend.apirest.models.services;

import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.roshka.springboot.backend.apirest.models.dao.IBolsaClienteDao;
import com.roshka.springboot.backend.apirest.models.entity.BolsaPuntos;

@Service
public class BolsasServiceImpl implements IBolsaService{

	@Autowired
	private IBolsaClienteDao bolsaDao;
	
	@Override
	@Transactional(readOnly = true)
	public BolsaPuntos findByCliente(Long cliente){
		return bolsaDao.findByCliente(cliente);
	}


}
