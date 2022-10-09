package com.biskot.app.rest;

import com.biskot.domain.DTO.ProductDto;
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


    @RequestMapping(value = "/{cartId}/items", method=RequestMethod.PUT, produces = "application/json")
    public Cart addToCart(@PathVariable Long cartId, @RequestBody ProductDto productDto){
        return cartService.addItemToCart(cartId, productDto );
    }




}
