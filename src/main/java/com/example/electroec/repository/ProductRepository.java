package com.example.electroec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.electroec.entity.Product;

public interface ProductRepository extends JpaRepository<Product, String> {

	public Product findBySerialNum(String serial);
}
