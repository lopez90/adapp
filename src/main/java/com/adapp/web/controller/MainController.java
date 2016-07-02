package com.adapp.web.controller;

import com.adapp.dao.interf.IUserDAO;
import com.adapp.dto.User;
import com.adapp.service.interf.IUserService;
import com.adapp.util.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @Autowired
    IUserDAO UserDao;

    @RequestMapping
    public String getIndex(Model model){
        User user = UserDao.findByMailWithCriteria("aolkiewicz@gmail.com");

        if(user != null)
            model.addAttribute("user", user);

        return "index";
    }

}
