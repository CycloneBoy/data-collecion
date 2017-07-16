package com.cycloneboy.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by CycloneBoy on 2017/7/16.
 */
//@Entity
//@Table(name = "t_product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id ;
    private String name ;
    private double price ;
    private boolean inStock ;
    private List<Comment> comments ;

    public Product() {
    }

    public Product(Integer id, String name, boolean inStock,double price) {
        this.id = id;
        this.name = name;
        this.inStock = inStock;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
