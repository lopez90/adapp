package com.adapp.dao.abstr;

import com.adapp.common.IOperations;
import com.google.common.base.Preconditions;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.internal.CriteriaImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Dom on 23.06.2016.
 */
@SuppressWarnings("unchecked")
public abstract class AbstractHibernateDAO<T extends Serializable> implements IOperations<T> {
    private Class<T> clazz;

    @Autowired
    private SessionFactory sessionFactory;

    // API

    protected final void setClazz(final Class<T> clazzToSet) {
        clazz = Preconditions.checkNotNull(clazzToSet);
    }
    protected final Class<T> getClazz(){
        return this.clazz;
    }

    @Override
    public final T findOne(final long id) {
        return (T) getCurrentSession().get(clazz, id);
    }

    @Override
    public final List<T> findAll() {
        return getCurrentSession().createQuery("from " + clazz.getName()).list();
    }

    @Override
    public final void create(final T entity) {
        Preconditions.checkNotNull(entity);
        // getCurrentSession().persist(entity);
        getCurrentSession().saveOrUpdate(entity);
    }

    @Override
    public final T update(final T entity) {
        Preconditions.checkNotNull(entity);
        return (T) getCurrentSession().merge(entity);
    }

    @Override
    public final void delete(final T entity) {
        Preconditions.checkNotNull(entity);
        getCurrentSession().delete(entity);
    }

    @Override
    public final void deleteById(final long entityId) {
        final T entity = findOne(entityId);
        Preconditions.checkState(entity != null);
        delete(entity);
    }

    // metoda templatka, generyczna
    // ma wyszukac jeden wynik na podstawie kryteriow które dostanie w liscie List<Criterion>
    public T findOneByCriteria(List<Criterion> criterions){
        Criteria criteria = getCurrentSession().createCriteria(getClazz()); // tutaj tworzysz z session criteria, jako parametr metoda getClazz() ktora zwraca obiekt klasy(DTO) np. User.class, Role.class

        // pakujesz wszystkie kryteria...
        for(Criterion criterion: criterions)
            criteria.add(criterion);

        return (T) criteria.uniqueResult(); // wywolujesz i zwracasz
    }

    public List<T> findManyByCriteria(List<Criterion> criterions){
        Criteria criteria = getCurrentSession().createCriteria(getClazz());

        for(Criterion criterion: criterions)
            criteria.add(criterion);

        return (List<T>) criteria.list();
    }

    protected final Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

}