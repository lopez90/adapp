package com.adapp.dao;

import com.adapp.dao.abstr.AbstractHibernateDAO;
import com.adapp.dao.interf.IUserDAO;
import com.adapp.dto.User;
import org.springframework.stereotype.Repository;

/**
 * Created by Dom on 22.06.2016.
 */
@Repository
public class UserDAO extends AbstractHibernateDAO<User> implements IUserDAO {

    public UserDAO(){
        super();
        setClazz(User.class);
    }

}
