package com.example.electroec.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.electroec.entity.Product;

public interface ProductRepository extends CrudRepository<Product, String> {

}
