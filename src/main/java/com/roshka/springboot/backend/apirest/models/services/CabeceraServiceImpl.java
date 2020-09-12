package com.roshka.springboot.backend.apirest.models.services;

import com.roshka.springboot.backend.apirest.models.dao.IBolsaClienteDao;
import com.roshka.springboot.backend.apirest.models.dao.ICabeceraDao;
import com.roshka.springboot.backend.apirest.models.dao.IClienteDao;
import com.roshka.springboot.backend.apirest.models.dao.IUsoPuntosDao;
import com.roshka.springboot.backend.apirest.models.entity.BolsaPuntos;
import com.roshka.springboot.backend.apirest.models.entity.Cabecera;
import com.roshka.springboot.backend.apirest.models.entity.Cliente;
import com.roshka.springboot.backend.apirest.models.entity.UsoPuntos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class CabeceraServiceImpl implements ICabeceraService{

    @Autowired
    private ICabeceraDao cabeceraDao;

    @Autowired
    private IUsoPuntosDao usoPuntosDao;

    @Autowired
    private IClienteDao clienteDao;

    @Autowired
    private IBolsaClienteDao bolsaClienteDao;

    @Override
    @Transactional(readOnly = true)
    public List<Cabecera> findAll() {
        return (List<Cabecera>)cabeceraDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Cabecera findById(Long id) {
        return cabeceraDao.findById(id).orElseThrow(null);
    }

    @Override
    @Transactional
    public Cabecera save(String id_cliente, String id_concepto) {
        UsoPuntos concepto = usoPuntosDao.findById(Long.parseLong(id_concepto)).orElseThrow(null);
        double puntosRequeridos = concepto.getPuntosRequeridos();
        Cliente cliente = clienteDao.findById(Long.parseLong(id_cliente)).orElseThrow(null);

        List<BolsaPuntos> bolsas = new ArrayList<>(cliente.getBolsas());
        List<BolsaPuntos> aEliminar = new ArrayList<>();

        for (BolsaPuntos bolsaPuntos : bolsas){
            if(bolsaPuntos.getSaldoPuntos() >= puntosRequeridos){
                bolsaPuntos.setPuntosUsados((int) (bolsaPuntos.getPuntosUsados() + puntosRequeridos));
                bolsaPuntos.setSaldoPuntos(bolsaPuntos.getPuntosAsignados() - bolsaPuntos.getPuntosUsados());
                if(bolsaPuntos.getSaldoPuntos() == 0)
                    bolsaClienteDao.deleteById(bolsaPuntos.getId());
            }else {

            }
        }

        return null;
    }
}
