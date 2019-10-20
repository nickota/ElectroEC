package com.example.electroec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.electroec.entity.CartItem;
import com.example.electroec.entity.User;
import com.example.electroec.repository.CartItemRepository;
import com.example.electroec.repository.ProductRepository;
import com.example.electroec.repository.UserRepository;

@Service
@Transactional(readOnly = false)
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
		CartItem cartItem = cartItemRepository.findOneByUserIdAndProductSerial(userId, productSerial);

		if (cartItem == null) {
			cartItem = new CartItem(userId, productSerial, quantity, user.getFirstName() + user.getLastName());
		} else {
			cartItem.setQuantity(cartItem.getQuantity() + quantity);
		}
		cartItemRepository.saveAndFlush(cartItem);
	}
}
