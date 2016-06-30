package com.adapp.listener;

import com.adapp.service.LoginAttemptServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

/**
 * Created by Dom on 27.06.2016.
 */
@Component
public class AuthenticationSuccessListener implements ApplicationListener<AuthenticationSuccessEvent>{

    @Autowired
    private LoginAttemptServiceImpl loginAttemptService;

    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent event) {
        WebAuthenticationDetails authenticationDetails = (WebAuthenticationDetails) event.getAuthentication().getDetails();

        if(authenticationDetails != null){
            loginAttemptService.loginSucceeded(authenticationDetails.getRemoteAddress());
        }
    }
}