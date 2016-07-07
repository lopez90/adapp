package com.adapp.listener;

import com.adapp.dto.User;
import com.adapp.service.interf.ITokenService;
import com.adapp.service.interf.IUserService;
import com.adapp.web.controller.event.OnRegistrationCompleteEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.MessageSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Created by Dom on 05.07.2016.
 */
@Component
public class RegistrationListener implements ApplicationListener<OnRegistrationCompleteEvent> {
    @Autowired
    private IUserService userService;
    @Autowired
    private ITokenService tokenService;
    @Autowired
    private MessageSource messages;
    @Autowired
    private JavaMailSender mailSender;


    @Override
    public void onApplicationEvent(OnRegistrationCompleteEvent event) {
        if(!event.isInvoked())
            this.confirmationEmail(event);

        event.setInvoked(true);
    }

    private void confirmationEmail(OnRegistrationCompleteEvent event){
        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        tokenService.createVerificationToken(user, token);

        SimpleMailMessage email = buildEmailMessage(event, user, token);

        mailSender.send(email);
    }

    private SimpleMailMessage buildEmailMessage(OnRegistrationCompleteEvent event, User user, String token) {
        String sentToAddress = user.getEmail();
        String subject = "subject";
        String confirmURL = "confirmurl" + token;
        String emailMessage = "email message";


        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(sentToAddress);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(emailMessage);
        simpleMailMessage.setFrom("przykladowyappadd@gmail.com");
        return simpleMailMessage;
    }
}
