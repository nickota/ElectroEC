package com.example.electroec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.electroec.entity.Products;

public interface ProductRepository extends JpaRepository<Products, String> {

}
