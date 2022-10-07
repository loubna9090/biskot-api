package com.biskot.domain.model;


import javax.persistence.*;

@Entity
public class Product {
    // TODO: to be implemented
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String productLabel;
    private float unitPrice;
    private int quantity_in_stock;

    @ManyToOne
    private Item item;

    //    constructors
    public Product() {
    }

    public Product(Long productId, String productLabel, float unitPrice, int quantity_in_stock) {
        this.productId = productId;
        this.productLabel = productLabel;
        this.unitPrice = unitPrice;
        this.quantity_in_stock = quantity_in_stock;
    }

    public Product(Long productId, String productLabel, float unitPrice, int quantity_in_stock, Item item) {
        this.productId = productId;
        this.productLabel = productLabel;
        this.unitPrice = unitPrice;
        this.quantity_in_stock = quantity_in_stock;
        this.item = item;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductLabel() {
        return productLabel;
    }

    public void setProductLabel(String productLabel) {
        this.productLabel = productLabel;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity_in_stock() {
        return quantity_in_stock;
    }

    public void setQuantity_in_stock(int quantity_in_stock) {
        this.quantity_in_stock = quantity_in_stock;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productLabel='" + productLabel + '\'' +
                ", unitPrice=" + unitPrice +
                ", quantity_in_stock=" + quantity_in_stock +
                ", item=" + item +
                '}';
    }
}
