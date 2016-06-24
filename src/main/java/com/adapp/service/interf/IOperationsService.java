package com.adapp.service.interf;

import com.adapp.dao.abstr.AbstractHibernateDAO;

import java.io.Serializable;

/**
 * Created by Dom on 24.06.2016.
 */
public interface IOperationsService< T extends Serializable> {

     public void create(T dao);
}
