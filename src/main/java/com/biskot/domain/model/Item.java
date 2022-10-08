package com.biskot.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
public class Item {
    // TODO: to be implemented

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long item_id;
    @JsonIgnore
    private float linePrice;

    @OneToMany
    private Collection<Product> products;


    public Item() {
    }

    public Item(Long item_id, float linePrice) {
        this.item_id = item_id;
        this.linePrice = linePrice;

    }

    public Item(Long item_id, float linePrice, Collection<Product> products) {
        this.item_id = item_id;
        this.linePrice = linePrice;
        this.products = products;
    }

    public Long getItem_id() {
        return item_id;
    }

    public void setItem_id(Long item_id) {
        this.item_id = item_id;
    }

    public float getLinePrice() {
        return linePrice;
    }

    public void setLinePrice(float linePrice) {
        this.linePrice = linePrice;
    }

    public Collection<Product> getProducts() {
        return products;
    }

    public void setProducts(Collection<Product> products) {
        this.products = products;
    }




}
