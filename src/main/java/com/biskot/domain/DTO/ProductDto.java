package com.biskot.domain.DTO;

import java.io.Serializable;
import java.util.Objects;

public class ProductDto implements Serializable {
    private final Long productId;
    private final int quantity;

    public ProductDto(Long productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public Long getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDto entity = (ProductDto) o;
        return Objects.equals(this.productId, entity.productId) &&
                Objects.equals(this.quantity, entity.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, quantity);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "productId = " + productId + ", " +
                "quantity = " + quantity + ")";
    }
}
