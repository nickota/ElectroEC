package com.example.electroec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.electroec.entity.Cart;
import com.example.electroec.entity.Product;

public interface CartRepository extends JpaRepository<Cart, Integer> {

	public List<Cart> findAllByCustomerId(Integer customerId);

	public Cart findOneByProduct(Product product);
}
