package com.adapp.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Dom on 20.06.2016.
 */

@Controller
public class MainController {

    @RequestMapping("/")
    public String Hello(){
        return "register";
    }


}
