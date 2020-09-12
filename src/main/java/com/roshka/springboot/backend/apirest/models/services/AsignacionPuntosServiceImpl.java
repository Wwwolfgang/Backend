package com.roshka.springboot.backend.apirest.models.services;

import com.roshka.springboot.backend.apirest.models.entity.VencimientoPuntos;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
	@Override
	@Transactional(readOnly = true)
	public Integer puntosEquivalente(String monto){
		List<AsignacionPuntos> Reglas = (List<AsignacionPuntos>) asignacionPuntosDao.findAll();
		BigDecimal Monto = new BigDecimal(String.valueOf(monto));
		int puntos = 0;

		for (AsignacionPuntos regla : Reglas) {
			if (Monto.compareTo(regla.getLimiteSuperior()) <= 1 && Monto.compareTo(regla.getLimiteInferior()) >= 0) {
				BigDecimal montoEquival = regla.getMontoEquivalente();
				puntos = Monto.divide(montoEquival, 0, RoundingMode.FLOOR).intValue();
				break;
			}
		}
		return puntos;
	}
	
	

}
