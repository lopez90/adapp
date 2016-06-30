package com.adapp.dao;

import com.adapp.dao.abstr.AbstractHibernateDAO;
import com.adapp.dao.interf.IUserDAO;
import com.adapp.dto.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

/**
 * Created by Dom on 22.06.2016.
 */
@Repository
public class UserDAO extends AbstractHibernateDAO<User> implements IUserDAO {

    public UserDAO(){
        super();
        setClazz(User.class);
    }

    @Override
    public User findByMail(String email) {

        Session session = getCurrentSession();
        Transaction tx = null;
        tx = session.beginTransaction();
        Query query = session.createNamedQuery("User_findByEmail")
                    .setParameter("email", email);
    }
}
