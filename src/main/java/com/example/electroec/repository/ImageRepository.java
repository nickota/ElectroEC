package com.example.electroec.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.electroec.entity.Review;

public interface ImageRepository extends CrudRepository<Review, Integer> {

}
