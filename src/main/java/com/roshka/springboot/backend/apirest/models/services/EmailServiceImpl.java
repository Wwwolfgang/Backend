package com.roshka.springboot.backend.apirest.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl {
    @Autowired
    private JavaMailSender emailSender;

    private void enviarComprobante(){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("wwwolfgang469@gmail.com");
        message.setTo("wwwolfgang469@fpuna.edu.py");
        message.setSubject("Test");
        message.setText("Test comprobante");
        emailSender.send(message);
    }
}
