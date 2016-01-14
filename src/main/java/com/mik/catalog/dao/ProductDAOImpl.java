package com.mik.catalog.dao;

import com.mik.catalog.dao.generic.GenericDAOImpl;
import com.mik.catalog.model.Product;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by mikitjuk on 13.01.16.
 */

public class ProductDAOImpl extends GenericDAOImpl<Product, Integer> implements ProductDAO{

    public ProductDAOImpl(Class<Product> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Product> findProduct(Product product) {
        @SuppressWarnings("unchecked")
        List <Product> products = getSession().createCriteria(Product.class).add(Example.create(product)).list();
        return products;
    }

    @Override
    public List<Product> getProductOfIdGroup(Integer idGroup) {
        @SuppressWarnings("unchecked")
        List <Product> products = getSession()
                .createCriteria(Product.class)
                .add(Restrictions.eq("groupByIdGroup.id", idGroup))
                .list();
        return products;
    }
}
