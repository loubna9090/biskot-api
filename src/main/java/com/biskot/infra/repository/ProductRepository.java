package com.biskot.infra.repository;

import com.biskot.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findProductByItem(Long idItem);
    Product findByProductId(Long idProd);


}
