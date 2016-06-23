package com.adapp.dao;

import com.adapp.dao.abstr.AbstractHibernateDAO;
import com.adapp.dao.interf.IUserDAO;
import com.adapp.dto.User;

/**
 * Created by Dom on 22.06.2016.
 */
public class UserDAO extends AbstractHibernateDAO< User > implements IUserDAO {

    public UserDAO(){
        super();
        setClazz(User.class );
    }

    @Override
    public User register(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        return user;
    }
}
