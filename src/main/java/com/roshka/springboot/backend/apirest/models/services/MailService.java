package com.roshka.springboot.backend.apirest.models.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;



@Service
public class MailService {

    @Autowired
    @Qualifier("gmail")
    private JavaMailSender mailSender;

    public void sendMail(String from, String subject, String toAddresses, String ccAddresses, String bccAddresses, String body) {
        MimeMessagePreparator preparator = mimeMessage -> {
            MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
            message.setTo(toAddresses.split("[,;]"));
            message.setFrom(from, "noreply@backend.com");
            message.setSubject(subject);
            if (!StringUtils.isEmpty(ccAddresses))
                message.setCc(ccAddresses.split("[;,]"));
            if (!StringUtils.isEmpty(bccAddresses))
                message.setBcc(bccAddresses.split("[;,]"));
            message.setText(body, false);
        };
        mailSender.send(preparator);

    }
}
