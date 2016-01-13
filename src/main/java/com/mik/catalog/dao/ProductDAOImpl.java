package com.mik.catalog.dao;

import com.mik.catalog.dao.generic.GenericDAOImpl;
import com.mik.catalog.model.Product;

/**
 * Created by mikitjuk on 13.01.16.
 */
//@Repository
public class ProductDAOImpl extends GenericDAOImpl<Product, Integer> implements ProductDAO{

    public ProductDAOImpl(Class<Product> entityClass) {
        super(entityClass);
    }
}
