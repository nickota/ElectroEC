package com.example.electroec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.electroec.entity.Products;
import com.example.electroec.repository.ProductRepository;

@Controller
public class ElectroEcController {

	@Autowired
	private ProductRepository productRepository;

	@RequestMapping("/index")
	public List<Products> get() {
		return productRepository.findAll();
	}
	// public String index() {
//		return "index";
//	}

//	@RequestMapping("/store")
//	public List<Products> get() {
//		return productRepository.findAll();
//	}
	// public String store() {
//		return "store";
//	}

//	@RequestMapping("/")
//	public String home(Model model) {
//		return "redirect:index";
//	}
}
