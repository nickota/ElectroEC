package com.example.electroec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.electroec.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

	public List<Review> findAllByProductSerial(String serial);
}
