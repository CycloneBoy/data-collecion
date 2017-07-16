package com.cycloneboy.domain;

import javax.persistence.*;

/**
 * Created by CycloneBoy on 2017/7/16.
 */
//@Entity
//@Table(name = "t_orderline")
public class OrderLine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Product product;

    private Integer amount;
    private double purchasePrice;

    public OrderLine() {
    }

    public OrderLine(Product product, Integer amount, double purchasePrice) {
        this.product = product;
        this.amount = amount;
        this.purchasePrice = purchasePrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }
}
