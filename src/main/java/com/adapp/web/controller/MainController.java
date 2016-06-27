package com.adapp.web.controller;

import com.adapp.dto.User;
import com.adapp.service.interf.IUserService;
import com.adapp.util.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * Created by Dom on 20.06.2016.
 */
@Controller
@RequestMapping(value = "/")
public class MainController {

    @Autowired
    IUserService userService;

    @RequestMapping
    public String getIndex(){
        return "index";
    }

    @RequestMapping(value="/register", method = RequestMethod.GET)
    public String getRegister(){
        return "register";
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody GenericResponse register(@RequestBody @Valid User user){
        userService.create(user);

        return new GenericResponse("Success");
    }

}
