package com.adapp.dao;

import com.adapp.dao.abstr.AbstractHibernateDAO;
import com.adapp.dao.interf.IRoleDAO;
import com.adapp.dto.Role;
import org.springframework.stereotype.Repository;

/**
 * Created by Andrzej Olkiewicz on 2016-07-01.
 */
@Repository
public class RoleDAO extends AbstractHibernateDAO<Role> implements IRoleDAO {

    public RoleDAO() {
        super();
        setClazz(Role.class);
    }


    @Override
    public Role findByName(String roleName) {
        return (Role) getCurrentSession().getNamedQuery("Role_findByName")
                .setString(":name", roleName)
                .uniqueResult();
    }
}