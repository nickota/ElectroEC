package com.example.electroec.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.electroec.entity.Product;
import com.example.electroec.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public Iterable<Product> findAll() {
		return productRepository.findAll();
	}

	public Optional<Product> findBySerialNum(String serialNum) {
		return productRepository.findById(serialNum);
	}

}
