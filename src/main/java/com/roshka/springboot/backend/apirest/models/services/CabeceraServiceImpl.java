package com.roshka.springboot.backend.apirest.models.services;

import com.roshka.springboot.backend.apirest.models.dao.*;
import com.roshka.springboot.backend.apirest.models.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class CabeceraServiceImpl implements ICabeceraService{

    @Autowired
    private ICabeceraDao cabeceraDao;

    @Autowired
    private IUsoPuntosDao usoPuntosDao;

    @Autowired
    private IClienteDao clienteDao;

    @Autowired
    private IDetalleDao detalleDao;

    @Autowired
    private MailService mailService;

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
    public String save(String id_cliente, String id_concepto) {
        Cabecera cabecera = new Cabecera();
        List<Detalle> detalles = new ArrayList<>();

        UsoPuntos concepto = usoPuntosDao.findById(Long.parseLong(id_concepto)).orElseThrow(null);
        double puntosRequeridos = concepto.getPuntosRequeridos();
        Cliente cliente = clienteDao.findById(Long.parseLong(id_cliente)).orElseThrow(null);
        long millis=System.currentTimeMillis();
        Date date = new Date(millis);

        List<BolsaPuntos> bolsas = new ArrayList<>(cliente.getBolsas());
        List<BolsaPuntos> bolsasUsadas = new ArrayList<>();

        cabecera.setCliente(cliente);
        cabecera.setPuntosUtilizados(puntosRequeridos);
        cabecera.setDescripcionPuntos(concepto.getDescripcionPuntos());
        cabecera.setFecha(date);

        for (BolsaPuntos bolsaPuntos : bolsas){
            if(bolsaPuntos.getSaldoPuntos() >= puntosRequeridos && date.compareTo(bolsaPuntos.getFechaCaducidad())<= 0){
                Detalle detalle = new Detalle();
                bolsaPuntos.setPuntosUsados((int) (bolsaPuntos.getPuntosUsados() + puntosRequeridos));
                bolsaPuntos.setSaldoPuntos(bolsaPuntos.getPuntosAsignados() - bolsaPuntos.getPuntosUsados());

                detalle.setBolsaPuntos(bolsaPuntos);
                detalle.setCabecera(cabecera);
                detalle.setCreateAt(date);
                detalle.setPuntosUtilizados(puntosRequeridos);

                detalles.add(detalle);

                for(BolsaPuntos bolsaPuntos1 : bolsasUsadas){
                    Detalle detalle_u = new Detalle();
                    detalle_u.setPuntosUtilizados((double)bolsaPuntos1.getSaldoPuntos());
                    detalle_u.setBolsaPuntos(bolsaPuntos1);
                    detalle_u.setCabecera(cabecera);
                    detalle_u.setCreateAt(date);

                    bolsaPuntos1.setSaldoPuntos(0);
                    bolsaPuntos1.setPuntosUsados(bolsaPuntos1.getPuntosAsignados());

                    detalles.add(detalle_u);
                }
                cabeceraDao.save(cabecera);
                detalleDao.saveAll(detalles);

                try {
                    mailService.sendMail("wwwolfgang469@gmail.com","Test",cliente.getEmail(),"","",
                            "Se aplicaron exitosamente " + concepto.getPuntosRequeridos() +
                                    " Puntos a "+ concepto.getDescripcionPuntos() + "! Gracias por su preferencia!!");

                    return "Puntos exitosamente usados, correo comprobante enviado!";
                }catch (Exception e){
                    return "Puntos exitosamente usados, correo comprobante no se pudo enviar!";
                }


            }else {
                bolsasUsadas.add(bolsaPuntos);
                puntosRequeridos -= bolsaPuntos.getSaldoPuntos();
            }
        }
        return "No se pudieron usar puntos";
    }
}
