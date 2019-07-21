package com.example.electroec.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.electroec.entity.ProductStatus;

public interface ProductStatusRepository extends CrudRepository<ProductStatus, Integer> {

}
