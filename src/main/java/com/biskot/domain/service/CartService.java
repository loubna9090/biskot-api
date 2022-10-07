package com.biskot.domain.service;

import com.biskot.domain.model.Cart;
import org.springframework.stereotype.Service;

@Service
public interface CartService {

    void createCart();

    Cart getCart(long cartId);

    Cart addItemToCart(long cartId, long productId, int quantityToAdd);
}
