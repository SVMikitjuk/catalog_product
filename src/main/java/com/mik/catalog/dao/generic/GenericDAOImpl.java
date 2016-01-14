package com.mik.catalog.dao.generic;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by mikitjuk on 13.01.16.
 */
@Repository
@Transactional
public abstract class GenericDAOImpl<T, PK extends Serializable> implements GenericDAO<T, PK>{

    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    private Class<T> entityClass;

    @SuppressWarnings("unchecked")
    public GenericDAOImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    @SuppressWarnings("unchecked")
    public PK create(T o){
        return (PK) getSession().save(o);
    }

    @Override
    @SuppressWarnings("unchecked")
    public T read(PK id) {
        return (T) getSession().get(entityClass, id);
    }

    @Override
    public void update(T o) {
        getSession().update(o);
    }

    @Override
    public void delete(T o) {
        getSession().delete(o);
    }

    @Override
    public List<T> listAll() {
        @SuppressWarnings("unchecked")
        List<T> listUser = (List<T>) sessionFactory.getCurrentSession()
                .createCriteria(entityClass).list();

        return listUser;
    }

    public Session getSession() {
        Session session = sessionFactory.getCurrentSession();
        session.setFlushMode(FlushMode.AUTO);
        return session;
    }
}
