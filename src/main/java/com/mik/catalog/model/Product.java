package com.mik.catalog.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by mikitjuk on 13.01.16.
 */
@Entity
@Table(name = "product")
public class Product implements Serializable {
    private Integer id;
    private String name;
    private Group groupByIdGroup;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne
    @JoinColumn(name = "id_group", referencedColumnName = "id", nullable = false)
    public Group getGroupByIdGroup() {
        return groupByIdGroup;
    }

    public void setGroupByIdGroup(Group groupByIdGroup) {
        this.groupByIdGroup = groupByIdGroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (id != null ? !id.equals(product.id) : product.id != null) return false;
        if (name != null ? !name.equals(product.name) : product.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

}
