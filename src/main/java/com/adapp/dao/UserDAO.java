package com.adapp.dao;

import com.adapp.dao.interf.IUserDAO;
import com.adapp.dto.User;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Dom on 22.06.2016.
 */
public class UserDAO implements IUserDAO {

    @Autowired
    User user;

    @Override
    public User register(String username, String password) {
        user.username=username;
        user.password=password;
        return user;
    }
}
