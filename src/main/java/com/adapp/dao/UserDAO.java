package com.adapp.dao;

import com.adapp.dao.abstr.AbstractHibernateDAO;
import com.adapp.dao.interf.IUserDAO;
import com.adapp.dto.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Dom on 22.06.2016.
 */
@Repository
@Transactional
public class UserDAO extends AbstractHibernateDAO<User> implements IUserDAO {

    public UserDAO(){
        super();
        setClazz(User.class);
    }

    @Override
    public User findByMail(String email) {
        return (User) getCurrentSession().getNamedQuery("findUserByEmail")
                .setParameter("email", email)
                .uniqueResult();
    }
}
