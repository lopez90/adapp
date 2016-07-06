package com.adapp.service;

import com.adapp.common.IOperations;
import com.adapp.dao.interf.IUserDAO;
import com.adapp.dao.interf.IVerificationTokenDAO;
import com.adapp.dto.User;
import com.adapp.dto.VerificationToken;
import com.adapp.service.abstr.AbstractService;
import com.adapp.service.interf.ITokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Dom on 06.07.2016.
 */
@Service
public class TokenServiceImpl extends AbstractService<VerificationToken> implements ITokenService {

    @Autowired
    private IVerificationTokenDAO dao;
    @Autowired
    private IUserDAO userDAO;

    @Override
    protected IOperations<VerificationToken> getDao() {
        return dao;
    }

    @Override
    public void createVerificationToken(User user, String token) {
        VerificationToken myToken = new VerificationToken(token, user);
        dao.create(myToken);
    }

    @Override
    public VerificationToken getVerificationToken(String token) {
        return dao.findByTokenWithCriteria(token);
    }


}
