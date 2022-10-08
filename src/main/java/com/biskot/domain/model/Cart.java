package com.biskot.domain.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cart {
    // TODO: to be implemented
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private float totalPrice;
    @OneToMany
    private List<Item> items;


    public Cart() {
    }

    public Cart(long id, float totalPrice) {
        this.id = id;

        this.totalPrice = totalPrice;
    }

    public Cart(long id, float totalPrice, List<Item> items) {
        this.id = id;

        this.totalPrice = totalPrice;
        this.items = items;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }



    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", totalPrice=" + totalPrice +
                ", items=" + items +
                '}';
    }
}
