package com.example.electroec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.electroec.entity.CartItem;
import com.example.electroec.entity.User;
import com.example.electroec.repository.CartItemRepository;
import com.example.electroec.repository.ProductRepository;

@Service
public class CartItemService {

	@Autowired
	CartItemRepository cartItemRepository;
	@Autowired
	ProductRepository productRepository;

	// TODO:imput user information
	User user = new User();

	public List<CartItem> findByUserId(Integer userId) {
		return cartItemRepository.findByUserId(userId);
	}

//	public void insert(Product product, Integer quantity) {
//		CartItem cartItem = new CartItem();
//		cartItem.setUser(user);
//		cartItem.setProduct(product);
//		cartItem.setQuantity(quantity);
//		cartItem.setInsertDate(new Date());
//		cartItem.setUpdateDate(new Date());
//		cartItem.setInsertUser(user.getId().toString());
//		cartItem.setUpdateUser(user.getId().toString());
//
//		cartRepository.saveAndFlush(cartItem);
//	}

//	public void update(Product product, Integer quantity) {
//		Cart cart = cartRepository.findOneByProductAndUser(product, user);
//		cart.setQuantity(cart.getQuantity() + quantity);
//		cartRepository.save(cart);
//	}
}
