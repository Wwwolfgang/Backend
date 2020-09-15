package com.roshka.springboot.backend.apirest.models.services;

import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.roshka.springboot.backend.apirest.models.dao.IClienteDao;
import com.roshka.springboot.backend.apirest.models.entity.Cliente;

@Service
public class ClienteServiceImpl implements IClienteService{

	@Autowired
	private IClienteDao clienteDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		return (List<Cliente>) clienteDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findById(Long id) {
		return clienteDao.findById(id).orElseThrow(null);
	}

	@Override
	@Transactional
	public Cliente save(Cliente cliente) {
		return clienteDao.save(cliente);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		clienteDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findByNombre(String nombre) {
		
		return clienteDao.findByNombre(nombre);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findByApellido(String apellido) {
		return clienteDao.findByApellido(apellido);
	}

	@Override
	
	public List<Cliente> findByCreateAt(Date createAt) {
		return clienteDao.findByCreateAt(createAt);
	}
	

}
