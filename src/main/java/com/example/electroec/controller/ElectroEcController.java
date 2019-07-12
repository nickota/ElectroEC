package com.example.electroec.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.electroec.entity.Products;
import com.example.electroec.service.ProductService;

@Controller
public class ElectroEcController {

	@Autowired
	private ProductService productService;

	@RequestMapping(path = "/products")
	@GetMapping
	public String index(Model model) {
		Iterable<Products> products = productService.findAll();
		model.addAttribute("products", products);
		return "products";
	}

	@RequestMapping(path = "/products/{serialNum}")
	@GetMapping
	public String getproduct(Model model, @PathVariable String serialNum) {
		Optional<Products> product = productService.findBySerialNum(serialNum);
		model.addAttribute("product", product);
		return "product";
	}
}
