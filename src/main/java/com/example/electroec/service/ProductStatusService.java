package com.example.electroec.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.electroec.entity.ProductStatus;
import com.example.electroec.repository.ProductStatusRepository;

@Service
public class ProductStatusService {

	@Autowired
	ProductStatusRepository statusRepository;

	public Iterable<ProductStatus> findAll() {
		return statusRepository.findAll();
	}

	public Optional<ProductStatus> findById(Integer id) {
		return statusRepository.findById(id);
	}
}
