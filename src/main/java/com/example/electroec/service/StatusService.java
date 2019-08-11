package com.example.electroec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.electroec.repository.StatusRepository;

@Service
public class StatusService {

	@Autowired
	StatusRepository statusRepository;
}
