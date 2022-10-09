package com.biskot.domain.spi;

import com.biskot.infra.gateway.payload.ProductResponse;
import org.springframework.http.ResponseEntity;

public interface ProductPort {

    ResponseEntity<ProductResponse> getProduct(long productId);

}
