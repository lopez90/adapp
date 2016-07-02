package com.adapp.service;

import com.adapp.common.IOperations;
import com.adapp.dao.interf.IUserDAO;
import com.adapp.dto.User;
import com.adapp.service.abstr.AbstractService;
import com.adapp.service.interf.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by Dom on 22.06.2016.
 */
@Service
public class UserServiceImpl extends AbstractService<User> implements IUserService{

    @Autowired
    private IUserDAO dao;

    @Override
    protected IOperations<User> getDao() {
        return dao;
    }

    @Override
    public void register(User user) {
        try {
            if(dao.findByMail(user.getEmail())== null){
                dao.create(user);
                if(dao.findOne(user.getId())==null){
                    throw new IOException();
                }
            } else {
                System.out.println("Użytkownik z podanym mailem istnieje");
            }
        } catch (IOException e) {
             e.getMessage();
        }
    }
}

