package com.adapp.web.controller;



import com.adapp.service.interf.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Dom on 20.06.2016.
 */

@Controller
public class MainController {

    @Autowired
    IUserService userService;


    @RequestMapping(value="/", method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public String Register(@RequestParam("username") String username, @RequestParam("password") String password ){
        userService.registerService(username,password);
        return "register";
    }
}
