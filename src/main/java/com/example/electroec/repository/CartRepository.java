package com.example.electroec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.electroec.entity.CartItems;

public interface CartRepository extends JpaRepository<CartItems, Integer> {

	List<CartItems> findByUserId(Integer userId);

}
