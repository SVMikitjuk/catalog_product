package com.mik.catalog.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by mikitjuk on 13.01.16.
 */
@Entity
@Table(name = "group_product", schema = "", catalog = "addrBook")
public class Group implements Serializable{

    private Integer id;
    private String name;
    private String dept;

    @JsonProperty("count")
    @Transient
    private Long countProduct;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, insertable = true, updatable = true, length = 250)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "dept", nullable = false, insertable = true, updatable = true, length = 100)
    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    @Formula("(select count(*) FROM addrBook.product pt where pt.id_group = id)")
    public Long getCountProduct() {
        return countProduct;
    }

    public void setCountProduct(Long countProduct) {
        this.countProduct = countProduct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Group that = (Group) o;

        if (dept != null ? !dept.equals(that.dept) : that.dept != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (dept != null ? dept.hashCode() : 0);
        return result;
    }
}
