package com.example.electroec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.electroec.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {

//	public List<Cart> findAllByUser(User user);

//	public Cart findOneByProductAndUser(Product product, User user);
}
