package com.adapp.service;

import com.adapp.common.IOperations;
import com.adapp.dao.VerificationTokenDAO;
import com.adapp.dao.interf.IUserDAO;
import com.adapp.dto.User;
import com.adapp.dto.VerificationToken;
import com.adapp.exceptions.UserAlreadyExistsException;
import com.adapp.service.abstr.AbstractService;
import com.adapp.service.interf.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

/**
 * Created by Dom on 22.06.2016.
 */
@Service
public class UserServiceImpl extends AbstractService<User> implements IUserService {

    @Autowired
    private IUserDAO dao;

    @Autowired
    private VerificationTokenDAO tokenDAO;

    @Override
    protected IOperations<User> getDao() {
        return dao;
    }

    @Override
    public void register(User user) {
        try {
            if (dao.findByMail(user.getEmail()) != null) {
                throw new UserAlreadyExistsException("User already exists in Database!");
            } else {
                dao.create(user);
            }
        } catch (UserAlreadyExistsException e) {
            e.getMessage();
        }

    }

    @Override
    public void createVerificationToken(User user, String token) {
        VerificationToken myToken = new VerificationToken(token, user);
        tokenDAO.create(myToken);
    }

    @Override
    public VerificationToken getVerificationToken(String token) {
        return tokenDAO.findByTokenWithCriteria(token);
    }


    public User findUserByEmail(String email){
        return dao.findByMail(email);
    }


}

