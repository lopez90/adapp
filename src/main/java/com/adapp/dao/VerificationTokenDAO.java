package com.adapp.dao;

import com.adapp.dao.abstr.AbstractHibernateDAO;
import com.adapp.dao.interf.IVerificationTokenDAO;
import com.adapp.dto.User;
import com.adapp.dto.VerificationToken;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dom on 05.07.2016.
 */
@Repository
@Transactional
public class VerificationTokenDAO extends AbstractHibernateDAO<VerificationToken> implements IVerificationTokenDAO {



    public VerificationTokenDAO(){
        super();
        setClazz(VerificationToken.class);
    }

    public VerificationToken findByTokenWithCriteria(String token){

        List<Criterion> criterionList = new ArrayList<>();
        criterionList.add(Restrictions.ilike("token", token, MatchMode.EXACT));

        return findOneByCriteria(criterionList);
    }

}
