package com.biskot.domain.service;

import com.biskot.domain.model.Cart;
import com.biskot.domain.model.Item;
import com.biskot.domain.model.Product;
import com.biskot.infra.repository.CartRepository;
import com.biskot.infra.repository.ItemRepository;
import com.biskot.infra.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void createCart() {
        // TODO: to be implemented
        float maxTotal=100f;
        int maxItemsCart=3;

        List<Product> listProd= new ArrayList<>();
        List<Item> listItems=new ArrayList<>();

        Cart cart= new Cart();
        Item itemList= new Item();
        Product prod=new Product();
        prod.setProductLabel(prod.getProductLabel());
        prod.setQuantity_in_stock(prod.getQuantity_in_stock());
        prod.setUnitPrice(prod.getUnitPrice());
        productRepository.save(prod);
        listProd.add(prod);
        itemList.setLinePrice(prod.getUnitPrice());
        if (itemList.getQuantity() <= maxItemsCart ){
            throw new ResourceAccessException("A cart cannot contain more than 3 different products");
        }
        itemList.setQuantity(itemList.getQuantity());
        itemList.setProducts(listProd);
        itemRepository.save(itemList);
        listItems.add(itemList);
        cart.setItems( listItems);
        if (cart.getTotalPrice() <= maxTotal ){
            throw new ResourceAccessException("Total price of the cart should not exceed 100 euros");
        }
        cart.setTotalPrice(itemList.getLinePrice()* itemList.getQuantity());
    }

    @Override
    public Cart getCart(long cartId) {
        // TODO: to be implemented
        return cartRepository.findById(cartId).get();
    }

    @Override
    public Cart addItemToCart(long cartId, long productId, int quantityToAdd) {
        // TODO: to be implemented
            Cart cart= getCart(cartId);
            Product prod= productRepository.findByProductId(productId);
            List<Product> listProd= new ArrayList<>();
            List<Item> listItems=new ArrayList<>();
            Item itemList= new Item();
            prod.setProductLabel(prod.getProductLabel());
            prod.setQuantity_in_stock(prod.getQuantity_in_stock());
            prod.setUnitPrice(prod.getUnitPrice());
            productRepository.save(prod);

            listProd.add(prod);

            if (itemList.getQuantity() <= quantityToAdd ){
                throw new ResourceAccessException("A cart cannot contain more than 3 different products");
            }
            itemList.setQuantity(quantityToAdd);
            itemList.setLinePrice(prod.getUnitPrice());
            itemList.setProducts(listProd);
            itemRepository.save(itemList);
            listItems.add(itemList);
            cart.setItems(listItems);
        return cartRepository.save(cart);


    }
    }

