package com.example.electroec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.electroec.entity.Products;
import com.example.electroec.service.ProductService;

@Controller
@RequestMapping(path = "/products")
public class ElectroEcController {

	@Autowired
	private ProductService productService;

	@GetMapping
	public String index(Model model) {
		Iterable<Products> products = productService.findAll();
		model.addAttribute("products", products);
		return "products";
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
