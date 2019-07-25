package com.example.electroec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.electroec.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

}
