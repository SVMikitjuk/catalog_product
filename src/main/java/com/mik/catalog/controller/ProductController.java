package com.mik.catalog.controller;

import com.mik.catalog.dao.GroupDAO;
import com.mik.catalog.dao.ProductDAO;
import com.mik.catalog.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by mikitjuk on 13.01.16.
 */
@RestController
public class ProductController {

    @Autowired
    @Qualifier("productDAO")
    private ProductDAO productDAO;
    @Autowired
    @Qualifier("groupDAO")
    private GroupDAO groupDAO;

    // получение всех продуктов
    @RequestMapping(value = "/product/list", method = RequestMethod.GET)
    public List<Product> productList() {
        List<Product> listAll = productDAO.listAll();
        return listAll.size() == 0 ? null : productDAO.listAll();
    }

    // создание нового продукта
    //{ "name": "name", "group": { "id": id } }
    @RequestMapping(value = "/product/create", method = RequestMethod.POST)
    public String newProduct(@RequestBody Product product) {

        String retStr;
        if (product.getGroupByIdGroup() == null
                || product.getGroupByIdGroup().getId() == 0
                || groupDAO.read(product.getGroupByIdGroup().getId()) == null) {
            retStr = "not find group";

        } else if (productDAO.findProduct(product).size() > 0) {
            retStr = "find similar - not add";

        } else if (product.getName() == null || product.getGroupByIdGroup() == null) {
            retStr = "not all fields are filled";

        } else {
            retStr = "Product add id = " + productDAO.create(product);
        }

        return retStr;
    }

    // получение продукта по id
    @RequestMapping(value = "/product/read", method = RequestMethod.GET)
    public Product readProduct(@RequestParam Integer id) {
        return productDAO.read(id);
    }

    // обновление продукта, перезапись полностью
    // in - { "id": id, "name": "dept", "dept": "dept" }
    @RequestMapping(value = "/product/update", method = RequestMethod.POST)
    public String editProduct(@RequestBody Product product) {
        //?? - обновление не очень хорошо
        productDAO.update(product);
        return "Update - ok";
    }

    // удаление продукта
    @RequestMapping(value = "/product/delete", method = RequestMethod.GET)
    public String deleteProduct(@RequestParam Integer id) {

        String retStr;
        Product product = productDAO.read(id);
        if (product == null) {
            retStr = "not find product id = " + id;
        } else {
            productDAO.delete(product);
            retStr = "Product deleted successfully!";
        }

        return retStr;
    }

    // полученеи продуктов по id группы
    @RequestMapping(value = "/product/get_of_id", method = RequestMethod.GET)
    public List<Product> getProductOfIdGroup(@RequestParam Integer id) {
        return productDAO.getProductOfIdGroup(id);
    }
}
