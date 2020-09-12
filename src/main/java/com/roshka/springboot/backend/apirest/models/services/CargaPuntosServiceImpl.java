package com.roshka.springboot.backend.apirest.models.services;

import com.roshka.springboot.backend.apirest.models.dao.IAsignacionPuntosDao;
import com.roshka.springboot.backend.apirest.models.dao.IBolsaClienteDao;
import com.roshka.springboot.backend.apirest.models.dao.IClienteDao;
import com.roshka.springboot.backend.apirest.models.dao.IVencimientoPuntosDao;
import com.roshka.springboot.backend.apirest.models.entity.AsignacionPuntos;
import com.roshka.springboot.backend.apirest.models.entity.BolsaPuntos;
import com.roshka.springboot.backend.apirest.models.entity.Cliente;
import com.roshka.springboot.backend.apirest.models.entity.VencimientoPuntos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.internet.MimeMessage;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class CargaPuntosServiceImpl implements ICargaPuntoService {

    @Autowired
    private IBolsaClienteDao bolsaClienteDao;

    @Autowired
    private IAsignacionPuntosDao asignacionPuntosDao;

    @Autowired
    private IClienteDao clienteDao;

    @Autowired
    private IVencimientoPuntosDao vencimientoPuntosDao;


    @Override
    @Transactional(readOnly = true)
    public List<BolsaPuntos> findAll() {
        return (List<BolsaPuntos>) bolsaClienteDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public BolsaPuntos findById(Long id){ return  bolsaClienteDao.findById(id).orElseThrow(null);}

    @Override
    @Transactional
    public BolsaPuntos save(String id, String monto) {
        //TODO hay que corregir las fechas. Ademas hay que ver como se agrega si no hay puntos.
        BolsaPuntos bolsaPuntos = new BolsaPuntos();
        long millis=System.currentTimeMillis();
        Date date = new Date(millis);
        List<AsignacionPuntos> Reglas = (List<AsignacionPuntos>) asignacionPuntosDao.findAll();
        List<VencimientoPuntos> Vencimientos = (List<VencimientoPuntos>)  vencimientoPuntosDao.findAll();

        BigDecimal Monto = new BigDecimal(monto);
        int puntos = 0;

        for (AsignacionPuntos regla : Reglas) {
            if (Monto.compareTo(regla.getLimiteSuperior()) <= 1 && Monto.compareTo(regla.getLimiteInferior()) >= 0) {
                BigDecimal montoEquival = regla.getMontoEquivalente();
                puntos = Monto.divide(montoEquival, 0, RoundingMode.FLOOR).intValue();
                break;
            }
        }
        if(puntos == 0)
            return null;
        //Fecha de caducidad
        bolsaPuntos.setFechaCaducidad(date);
        for (VencimientoPuntos vencimiento : Vencimientos){
            if(date.compareTo(vencimiento.getFechaInicio()) >= 0 && date.compareTo(vencimiento.getFechaFin()) <= 0){
                long dias = vencimiento.getDiasDuracion().longValue();
                LocalDate fecha = LocalDate.now().plusDays(dias);
                if(vencimiento.getFechaFin().compareTo(Date.valueOf(fecha)) >=0){
                    bolsaPuntos.setFechaCaducidad(Date.valueOf(fecha));
                }else {
                    bolsaPuntos.setFechaCaducidad(vencimiento.getFechaFin());
                }
                break;
            }
        }


        //Puntos asignados
        bolsaPuntos.setPuntosAsignados(puntos);

        //Monto de compra
        bolsaPuntos.setMontoOperacion(new BigDecimal(monto));

        //Puntos usados y saldo de puntos
        bolsaPuntos.setPuntosUsados(0);
        bolsaPuntos.setSaldoPuntos(bolsaPuntos.getPuntosAsignados());

        //Fecha de asignacion y created_at
        bolsaPuntos.setFechaAsignacion(date);

        //Asignacion cliente
        Cliente cliente = clienteDao.findById(Long.parseLong(id)).orElseThrow(null);
        bolsaPuntos.setCliente(cliente);
        enviarComprobante();

        return bolsaClienteDao.save(bolsaPuntos);}

    @Override
    @Transactional
    public void delete(Long id){
        bolsaClienteDao.deleteById(id);
    }

    @Override
    public void enviarComprobante() {
        JavaMailSender emailSender= new JavaMailSender() {
            @Override
            public MimeMessage createMimeMessage() {
                return null;
            }

            @Override
            public MimeMessage createMimeMessage(InputStream inputStream) throws MailException {
                return null;
            }

            @Override
            public void send(MimeMessage mimeMessage) throws MailException {

            }

            @Override
            public void send(MimeMessage... mimeMessages) throws MailException {

            }

            @Override
            public void send(MimeMessagePreparator mimeMessagePreparator) throws MailException {

            }

            @Override
            public void send(MimeMessagePreparator... mimeMessagePreparators) throws MailException {

            }

            @Override
            public void send(SimpleMailMessage simpleMailMessage) throws MailException {

            }

            @Override
            public void send(SimpleMailMessage... simpleMailMessages) throws MailException {

            }
        };


            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("wwwolfgang469@gmail.com");
            message.setTo("wwwolfgang469@fpuna.edu.py");
            message.setSubject("Test");
            message.setText("Test comprobante");
            emailSender.send(message);

    }


}
