package com.adapp.dao;

import com.adapp.dao.abstr.AbstractHibernateDAO;
import com.adapp.dao.interf.IUserDAO;
import com.adapp.dto.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.internal.CriteriaImpl;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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

    // override z interfejsu IUserDAO
    @Override
    public User findByMailWithCriteria(String email) {
        // tworzysz liste do ktorej pakujesz kryteria, obostrzenia wedlug czego ma stworzyc SQL'a
        List<Criterion> criterionList = new ArrayList<>();
        criterionList.add(Restrictions.ilike("email", email, MatchMode.ANYWHERE));

        return findOneByCriteria(criterionList); // zwracasz na podstawie metody generycznej z AbstractHbnDAO
    }
}
