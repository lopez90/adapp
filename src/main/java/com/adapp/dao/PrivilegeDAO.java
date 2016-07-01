package com.adapp.dao;

import com.adapp.dao.abstr.AbstractHibernateDAO;
import com.adapp.dao.interf.IPrivilegeDAO;
import com.adapp.dao.interf.IPrivilegeDAO;
import com.adapp.dto.Privilege;

/**
 * Created by Dom on 01.07.2016.
 */
public class PrivilegeDAO extends AbstractHibernateDAO<Privilege> implements IPrivilegeDAO {

    public PrivilegeDAO(){
        super();
        setClazz(Privilege.class);
    }
}
