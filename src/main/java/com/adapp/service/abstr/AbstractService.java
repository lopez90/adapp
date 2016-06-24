package com.adapp.service.abstr;


import com.adapp.dao.abstr.AbstractHibernateDAO;


import com.adapp.service.interf.IOperationsService;


import java.io.Serializable;


/**
 * Created by Dom on 24.06.2016.
 */
public abstract class AbstractService<T extends AbstractHibernateDAO> implements IOperationsService<T> {


    void public create(T dto){
        dao.create(dto);
    }

}
