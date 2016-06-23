package com.adapp.service;


import com.adapp.dao.interf.IUserDAO;
import com.adapp.dto.User;
import com.adapp.service.interf.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Dom on 22.06.2016.
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    IUserDAO userDAO;

    @Override
    public void saveUser(User user) {
        userDAO.create(user);
    }
}
