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
public abstract class GenericDAOImpl<T, PK extends Serializable> implements GenericDAO<T, PK>{

    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;
//    static final Logger logger = LoggerFactory.getLogger(GenericMySqlDAOImpl.class);

    private Class<T> entityClass;

    @SuppressWarnings("unchecked")
    public GenericDAOImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    @Transactional
    @SuppressWarnings("unchecked")
    public PK create(T o){
        return (PK) getSession().save(o);
    }

    @Override
    @Transactional
    @SuppressWarnings("unchecked")
    public T read(PK id) {
        return (T) getSession().get(entityClass, id);
    }

    @Override
    @Transactional
    public void update(T o) {
        getSession().update(o);
    }

    @Override
    @Transactional
    public void delete(T o) {
        getSession().delete(o);
    }

    @Override
    @Transactional
    public List<T> listAll() {
        @SuppressWarnings("unchecked")
        List<T> listUser = (List<T>) sessionFactory.getCurrentSession()
                .createCriteria(entityClass).list();
                //.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

        return listUser;
    }

    public Session getSession() {
        Session session = sessionFactory.getCurrentSession();
        session.setFlushMode(FlushMode.AUTO);
        return session;
    }

}
