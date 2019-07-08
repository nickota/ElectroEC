package com.example.electroec.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.electroec.entity.Products;

public interface ProductRepository extends CrudRepository<Products, String> {

}
