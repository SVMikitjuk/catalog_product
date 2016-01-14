package com.mik.catalog.dao;

import com.mik.catalog.dao.generic.GenericDAOImpl;
import com.mik.catalog.model.Group;
import org.hibernate.criterion.Example;

import java.util.List;

/**
 * Created by mikitjuk on 13.01.16.
 */

public class GroupDAOImpl extends GenericDAOImpl<Group, Integer> implements GroupDAO {

    public GroupDAOImpl(Class<Group> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Group> findGroup(Group group) {
        @SuppressWarnings("unchecked")
        List <Group> groups = getSession().createCriteria(Group.class).add(Example.create(group)).list();
        return groups;
    }
}
