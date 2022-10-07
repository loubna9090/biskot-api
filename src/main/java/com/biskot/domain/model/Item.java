package com.biskot.domain.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
public class Item {
    // TODO: to be implemented

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long item_id;
    private float linePrice;
    private int quantity;
    @OneToMany
    private Collection<Product> products;


    public Item() {
    }

    public Item(Long item_id, float linePrice, int quantity) {
        this.item_id = item_id;
        this.linePrice = linePrice;
        this.quantity = quantity;
    }

    public Item(Long item_id, float linePrice, int quantity, Collection<Product> products) {
        this.item_id = item_id;
        this.linePrice = linePrice;
        this.quantity = quantity;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Item{" +
                "item_id=" + item_id +
                ", linePrice=" + linePrice +
                ", products=" + products +
                '}';
    }
}
