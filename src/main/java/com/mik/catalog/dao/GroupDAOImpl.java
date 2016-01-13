package com.mik.catalog.dao;

import com.mik.catalog.dao.generic.GenericDAOImpl;
import com.mik.catalog.model.Group;

/**
 * Created by mikitjuk on 13.01.16.
 */
//@Repository
public class GroupDAOImpl extends GenericDAOImpl<Group, Integer> implements GroupDAO {

    public GroupDAOImpl(Class<Group> entityClass) {
        super(entityClass);
    }
}
