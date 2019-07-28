package com.example.electroec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.electroec.entity.Product;
import com.example.electroec.entity.ProductStatus;
import com.example.electroec.entity.Review;
import com.example.electroec.service.ProductService;
import com.example.electroec.service.ProductStatusService;
import com.example.electroec.service.ReviewService;

@Controller
public class ElectroEcController {

	@Autowired
	private ProductService productService;
	@Autowired
	private ProductStatusService statusService;
	@Autowired
	private ReviewService reviewService;

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

	@RequestMapping(path = "/product/{serialNum}")
	@GetMapping
	public String getproduct(@PathVariable String serialNum, Model model) {
		Product product = productService.findBySerialNum(serialNum).orElse(null);
		ProductStatus status = statusService.findById(product.getStatus()).orElse(null);
		List<Review> reviews = reviewService.findAll();
		model.addAttribute("product", product);
		model.addAttribute("reviews", reviews);
		model.addAttribute("reviewCount", reviews.size());
		model.addAttribute("status", status.getStatus());
		return "product";
	}

}
