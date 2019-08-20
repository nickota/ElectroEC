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

		Integer customerId = new Integer(1);
		Integer quantity = new Integer(1);

		List<Cart> cartInfos = findAll(customerId);
		for (Cart cartinfo : cartInfos) {

			// update
			if (cartinfo.getProduct().getSerialNum().equals(serialNum)) {
				Cart cart = cartRepository.findOneByProduct(productRepository.findBySerialNum(serialNum));
				cart.setQuantity(cart.getQuantity() + quantity);
				cartRepository.save(cart);
				// insert
			} else {
				Cart cart = new Cart();
				cart.setCustomerId(customerId);
				cart.setProduct(productRepository.getOne(serialNum));
				cart.setQuantity(quantity);
				cart.setInsertDate(new Date());
				cart.setUpdateDate(new Date());
				cart.setInsertUser(customerId.toString());
				cart.setUpdateUser(customerId.toString());

				cartRepository.save(cart);

			}
		}
	}
}
