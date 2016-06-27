package com.adapp.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Dom on 27.06.2016.
 */
@Controller
@RequestMapping(value = "/user/")
public class UserController {

    @RequestMapping(value="/add", method = RequestMethod.GET)
    public String getRegister2(){
        return "register2";
    }
}
