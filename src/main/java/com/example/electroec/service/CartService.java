package com.example.electroec.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.electroec.entity.Cart;
import com.example.electroec.entity.Product;
import com.example.electroec.entity.User;
import com.example.electroec.repository.CartRepository;
import com.example.electroec.repository.ProductRepository;

@Service
public class CartService {

	@Autowired
	CartRepository cartRepository;
	@Autowired
	ProductRepository productRepository;

	public List<Cart> findAll(User user) {
		return cartRepository.findAllByUser(user);
	}

	// TODO:imput user information
	User user = new User();

	public void insert(Product product, Integer quantity) {
		Cart cart = new Cart();
		cart.setUser(user);
		cart.setProduct(product);
		cart.setQuantity(quantity);
		cart.setInsertDate(new Date());
		cart.setUpdateDate(new Date());
		cart.setInsertUser(user.getId().toString());
		cart.setUpdateUser(user.getId().toString());

		cartRepository.saveAndFlush(cart);
	}

	public void update(Product product, Integer quantity) {
		Cart cart = cartRepository.findOneByProductAndUser(product, user);
		cart.setQuantity(cart.getQuantity() + quantity);
		cartRepository.save(cart);
	}
}
