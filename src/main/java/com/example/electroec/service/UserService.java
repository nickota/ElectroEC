package com.example.electroec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.electroec.entity.User;
import com.example.electroec.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public User findOne(Integer id) {
		return userRepository.findOneById(id);
	}
}
