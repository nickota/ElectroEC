package com.example.electroec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.electroec.entity.Cart;
import com.example.electroec.repository.CartRepository;

@Service
public class CartService {

	@Autowired
	CartRepository cartRepository;

	public List<Cart> findAll(Integer customerId) {
		return cartRepository.findAllByCustomerId(customerId);
	}
}
