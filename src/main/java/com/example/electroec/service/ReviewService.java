package com.example.electroec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.electroec.entity.Review;
import com.example.electroec.repository.ReviewRepository;

@Service
public class ReviewService {

	@Autowired
	ReviewRepository reviewRepository;

	public List<Review> findall() {
		return reviewRepository.findAll();
	}
}
