package com.adapp.service;

import com.adapp.dao.UserDAO;
import com.adapp.service.interf.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Dom on 22.06.2016.
 */
public class UserServiceImpl implements IUserService {

    @Autowired
    UserDAO userDAO;

    @Override
    public void registerService(String username, String password) {
        userDAO.register(username, password);
    }
}
