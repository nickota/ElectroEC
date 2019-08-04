package com.example.electroec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.electroec.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {

	public List<Cart> findByCustomerId(Integer customerId);
}
