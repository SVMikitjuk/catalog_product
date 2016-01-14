package com.mik.catalog.dao;

import com.mik.catalog.dao.generic.GenericDAO;
import com.mik.catalog.model.Group;

import java.util.List;

/**
 * Created by mikitjuk on 13.01.16.
 */
public interface GroupDAO extends GenericDAO<Group, Integer> {

    List<Group> findGroup(Group group);
}
