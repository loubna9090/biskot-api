package com.biskot.infra.gateway;

import com.biskot.domain.model.Product;
import com.biskot.domain.spi.ProductPort;
import com.biskot.infra.gateway.payload.ProductResponse;
import com.biskot.infra.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

public class ProductGateway implements ProductPort {
    @Autowired
    ProductRepository productRepository;

    public ResponseEntity<ProductResponse> getProduct(long productId) {
        // TODO: to be implemented
        Product prod= new Product();
        String label= prod.getProductLabel();
        float priceUnit=prod.getUnitPrice();
        int quantityStock = prod.getQuantity_in_stock();
        ProductResponse  response= new ProductResponse(productId, label, priceUnit, quantityStock);
        return ResponseEntity.ok(response);
    }

}
