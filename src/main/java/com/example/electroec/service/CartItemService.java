package com.example.electroec.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.electroec.entity.CartItem;
import com.example.electroec.entity.User;
import com.example.electroec.repository.CartItemRepository;
import com.example.electroec.repository.ProductRepository;
import com.example.electroec.repository.UserRepository;

@Service
public class CartItemService {

	@Autowired
	CartItemRepository cartItemRepository;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	UserRepository userRepository;

	Integer userId = 1;

	public List<CartItem> findByUserId(Integer userId) {
		return cartItemRepository.findByUserId(userId);
	}

	/**
	 * Update CartItem table.
	 * 
	 * If there is a same product in the cart, it will update the quantity. <br>
	 * If there isn't, it will make a new record.
	 * 
	 * @param productSerial
	 * @param quantity
	 */
	public void add(String productSerial, Integer quantity) {
		User user = userRepository.getOne(userId);
		CartItem targetCartItem = cartItemRepository.findOneByUserIdAndProductSerial(userId, productSerial);

		if (targetCartItem == null) {
			CartItem cartItem = new CartItem();
			cartItem.setUserId(userId);
			cartItem.setProductSerial(productSerial);
			cartItem.setQuantity(quantity);
			cartItem.setInsertDate(new Date());
			cartItem.setUpdateDate(new Date());
			cartItem.setInsertUser(user.getFirstName() + user.getLastName());
			cartItem.setUpdateUser(user.getFirstName() + user.getLastName());
			cartItemRepository.saveAndFlush(cartItem);
		} else {
			CartItem cartItem = cartItemRepository.findOneByUserIdAndProductSerial(userId, productSerial);
			cartItem.setQuantity(cartItem.getQuantity() + quantity);
			cartItemRepository.saveAndFlush(cartItem);
		}
	}
}
