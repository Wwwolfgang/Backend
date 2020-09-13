package com.roshka.springboot.backend.apirest.models.Tareas;

import com.roshka.springboot.backend.apirest.models.dao.IBolsaClienteDao;
import com.roshka.springboot.backend.apirest.models.entity.BolsaPuntos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Component
public class TareasProgramadas {

    @Autowired
    private IBolsaClienteDao bolsaClienteDao;

    @Scheduled(fixedRate = 60000,initialDelay = 3000)
    @Transactional
    public void actualizarBolsas(){
        List<BolsaPuntos> bolsasRevision = (List<BolsaPuntos>)bolsaClienteDao.findAll();
        long millis=System.currentTimeMillis();
        Date date = new Date(millis);
        for(BolsaPuntos bolsaPuntos: bolsasRevision){
            if(bolsaPuntos.getFechaCaducidad().compareTo(date) < 0 && bolsaPuntos.getSaldoPuntos() != 0){
                int saldo = 0;
                bolsaPuntos.setSaldoPuntos(saldo);
            }
        }
    }
}
