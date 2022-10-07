package com.biskot.app.rest;

import com.biskot.domain.model.Cart;
import com.biskot.domain.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/carts")
public class CartController {
    // TODO: to be implemented
    @Autowired
    CartService cartService;


@GetMapping("/{cartId}")
public Cart getCart(@PathVariable Long cartId){
    return cartService.getCart(cartId);
}
@PutMapping("/{cartId}/items")
public Cart addToCart(@PathVariable Long cartId, @RequestBody Long  productId, @RequestBody int quantity){
    Cart cart= cartService.addItemToCart(cartId, productId, quantity );
    return cart;
}


}
