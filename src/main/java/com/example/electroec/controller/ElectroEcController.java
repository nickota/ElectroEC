package com.example.electroec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.electroec.entity.Product;
import com.example.electroec.service.ProductService;

@Controller
public class ElectroEcController {

	@Autowired
	private ProductService productService;

	@RequestMapping(path = "/")
	@GetMapping
	public String index(Model model) {
		Iterable<Product> products = productService.findAll();
		model.addAttribute("products", products);
		return "top";
	}

	@RequestMapping(path = "/store")
	@GetMapping
	public String store(Model model) {
		Iterable<Product> products = productService.findAll();
		model.addAttribute("products", products);
		return "store";
	}

	@RequestMapping(path = "/product/a")
	@GetMapping
	public String getproduct(Model model) {
		String serialNum = "PC0001";
		Product product = productService.findBySerialNum(serialNum).orElse(null);
		model.addAttribute("product", product);
		return "product";
	}

}
