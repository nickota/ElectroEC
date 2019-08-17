package com.example.electroec.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.electroec.entity.Cart;
import com.example.electroec.repository.CartRepository;
import com.example.electroec.repository.ProductRepository;

@Service
public class CartService {

	@Autowired
	CartRepository cartRepository;
	@Autowired
	ProductRepository productRepository;

	public List<Cart> findAll(Integer customerId) {
		return cartRepository.findAllByCustomerId(customerId);
	}

	public void add(String serialNum) {
		Cart cart = new Cart();
		Integer customerId = new Integer(1);
		cart.setCustomerId(customerId);
		cart.setProduct(productRepository.getOne(serialNum));
		cart.setQuantity(1);
		cart.setInsertDate(new Date());
		cart.setUpdateDate(new Date());
		cart.setInsertUser(customerId.toString());
		cart.setUpdateUser(customerId.toString());

		cartRepository.save(cart);
	}
}
