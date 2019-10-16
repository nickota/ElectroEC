package com.example.electroec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.electroec.entity.CartItem;

public interface CartRepository extends JpaRepository<CartItem, Integer> {

	List<CartItem> findByUserId(Integer userId);

}
