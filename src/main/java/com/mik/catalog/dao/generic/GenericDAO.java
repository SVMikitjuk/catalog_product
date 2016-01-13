package com.mik.catalog.dao.generic;

import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;

/**
 * Created by mikitjuk on 13.01.16.
 */
public interface GenericDAO<T, PK extends Serializable> {

    PK create(T newInstance);

    T read(PK id);

    void update(T transientObject);

    void delete(T persistentObject);

    List<T> listAll();

    Session getSession();

}
