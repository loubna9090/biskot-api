package com.biskot;

import com.biskot.domain.model.Cart;
import com.biskot.domain.model.Item;
import com.biskot.domain.model.Product;
import com.biskot.infra.repository.CartRepository;
import com.biskot.infra.repository.ItemRepository;
import com.biskot.infra.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication(scanBasePackages = "com.biskot")
public class BiskotApiApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(BiskotApiApplication.class, args);
	}

	@Autowired(required=false)
	 ProductRepository productRepository;
	@Autowired(required=false)
	ItemRepository itemRepository;
	@Autowired(required=false)
	CartRepository cartRepository;

	@Override
	public void run(String... args) throws Exception {
		Product prod=new Product();
		prod.setProductLabel("adidas deo");
		prod.setUnitPrice(5);
		prod.setQuantity(2);
		prod.setQuantity_in_stock(100);
		productRepository.save(prod);

		Product prod2=new Product();
		prod2.setProductLabel("reebok");
		prod2.setUnitPrice(8);
		prod2.setQuantity(2);
		prod2.setQuantity_in_stock(100);
		productRepository.save(prod2);

		Product prod1=new Product();
		prod1.setProductLabel("nike ");
		prod1.setUnitPrice(10);
		prod1.setQuantity(3);
		prod1.setQuantity_in_stock(100);
		productRepository.save(prod1);

		List<Product> listProds= new ArrayList<>();
		listProds.add(prod);
		listProds.add(prod1);
		Item item= new Item();
		item.setProducts(listProds);
		item.setLinePrice(prod.getUnitPrice());
		itemRepository.save(item);

		List<Item> listItems= new ArrayList<>();
		listItems.add(item);
		Cart cart =new Cart();
		cart.setItems(listItems);
		float total = 0;
		for(Product product : listProds
		) {
			float result= product.getUnitPrice() * product.getQuantity();
			total= total + result;

		}
		cart.setTotalPrice(total);
		cartRepository.save(cart);





	}





}
