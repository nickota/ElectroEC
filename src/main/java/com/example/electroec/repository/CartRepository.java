package com.example.electroec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.electroec.entity.Cart;
import com.example.electroec.entity.Product;
import com.example.electroec.entity.User;

public interface CartRepository extends JpaRepository<Cart, Integer> {

	public List<Cart> findAllByUser(User user);

	public Cart findOneByProductAndUser(Product product, User user);
}
