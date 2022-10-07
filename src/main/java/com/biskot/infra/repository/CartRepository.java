package com.biskot.infra.repository;

import com.biskot.domain.model.Cart;
import com.biskot.domain.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {
    Cart findCartByItems(Item item);
}
