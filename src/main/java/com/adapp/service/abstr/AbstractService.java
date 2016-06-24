package com.adapp.service.abstr;


import com.adapp.dao.abstr.AbstractHibernateDAO;


import com.adapp.service.interf.IOperationsService;


import java.io.Serializable;


/**
 * Created by Dom on 24.06.2016.
 */
public abstract class AbstractService<T extends AbstractHibernateDAO, E extends Serializable> implements IOperationsService<T,E> {

    void public create(T dao, E dto){
        dao.create(dto);
    }

}
