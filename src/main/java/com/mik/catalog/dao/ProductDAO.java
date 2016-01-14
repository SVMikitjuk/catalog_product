package com.mik.catalog.dao;

import com.mik.catalog.dao.generic.GenericDAO;
import com.mik.catalog.model.Product;

import java.util.List;

/**
 * Created by mikitjuk on 13.01.16.
 */
public interface ProductDAO extends GenericDAO<Product, Integer> {

    List<Product> findProduct(Product product);
    List<Product> getProductOfIdGroup(Integer idGroup);
}
