package com.adapp.web.controller;

import com.adapp.dto.User;
import com.adapp.dto.VerificationToken;
import com.adapp.service.interf.ITokenService;
import com.adapp.service.interf.IUserService;
import com.adapp.util.GenericResponse;
import com.adapp.web.controller.event.OnRegistrationCompleteEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.validation.Valid;
import java.util.Calendar;
import java.util.Locale;



/**
 * Created by Dom on 27.06.2016.
 */
@Controller
@RequestMapping(value = "/user/")
public class UserController {

    @Autowired
    IUserService userService;

    @Autowired
    ITokenService tokenService;

    @Autowired
    ApplicationEventPublisher eventPublisher;

    @RequestMapping(value="/add", method = RequestMethod.GET)
    public String getRegisterForm(){
        return "register";
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody GenericResponse registerUserAccount(@RequestBody @Valid User accountDto) {
        userService.register(accountDto);
        return new GenericResponse("success");
    }

    @RequestMapping(value="/successRegister", method = RequestMethod.GET)
    public String successRegister(){
        return "successRegister";
    }


    @RequestMapping(value = "/regitrationConfirm", method = RequestMethod.GET)
    public String confirmRegistration
            (WebRequest request, Model model, @RequestParam("token") String token) {
        Locale locale = request.getLocale();

        VerificationToken verificationToken = tokenService.getVerificationToken(token);
        if (verificationToken == null) {
            return "redirect:/badUser.html?lang=" + locale.getLanguage();
        }

        User user = verificationToken.getUser();
        Calendar cal = Calendar.getInstance();
        if ((verificationToken.getDateExpire().getTime() - cal.getTime().getTime()) <= 0) {
            return "redirect:/badUser.html?lang=" + locale.getLanguage();
        }

        user.setEnabled(true);
        userService.update(user);
        return "redirect:/login.html?lang=" + request.getLocale().getLanguage();
    }
}
