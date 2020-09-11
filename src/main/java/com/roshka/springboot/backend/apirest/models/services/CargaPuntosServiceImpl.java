package com.roshka.springboot.backend.apirest.models.services;

import com.roshka.springboot.backend.apirest.models.dao.IAsignacionPuntosDao;
import com.roshka.springboot.backend.apirest.models.dao.IBolsaClienteDao;
import com.roshka.springboot.backend.apirest.models.dao.IClienteDao;
import com.roshka.springboot.backend.apirest.models.entity.AsignacionPuntos;
import com.roshka.springboot.backend.apirest.models.entity.BolsaPuntos;
import com.roshka.springboot.backend.apirest.models.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CargaPuntosServiceImpl implements ICargaPuntoService {

    @Autowired
    private IBolsaClienteDao bolsaClienteDao;

    @Autowired
    private IAsignacionPuntosDao asignacionPuntosDao;

    @Autowired
    private IClienteDao clienteDao;


    @Override
    @Transactional(readOnly = true)
    public List<BolsaPuntos> findAll() {
        return (List<BolsaPuntos>) bolsaClienteDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public BolsaPuntos findById(Long id){ return  bolsaClienteDao.findById(id).orElseThrow(null);}

    @Override
    @Transactional(readOnly = true)
    public BolsaPuntos save(String id, String monto) {
        BolsaPuntos bolsaPuntos = new BolsaPuntos();
        List<AsignacionPuntos> Reglas = (List<AsignacionPuntos>) asignacionPuntosDao.findAll();
        BigDecimal Monto = new BigDecimal(monto);
        for(int i=0;i<Reglas.size();i++){
            if(Monto.compareTo(Reglas.get(i).getLimiteSuperior()) <= 1 && Monto.compareTo(Reglas.get(i).getLimiteInferior()) >= 1){
                BigDecimal montoEquival = Reglas.get(i).getMontoEquivalente();
                int j=1;
                Monto = Monto.subtract(montoEquival);
                while (Monto.compareTo(Reglas.get(i).getLimiteInferior()) >= 1){
                    bolsaPuntos.setPuntosAsignados(j);
                    j++;
                }

            }
        }
        Cliente cliente = clienteDao.findById(Long.parseLong(id)).orElseThrow(null);
        bolsaPuntos.setCliente(cliente);
        return bolsaClienteDao.save(bolsaPuntos);}

    @Override
    @Transactional
    public void delete(Long id){
        bolsaClienteDao.deleteById(id);
    }


}
