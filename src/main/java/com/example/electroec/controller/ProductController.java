package com.example.electroec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.electroec.service.ProductService;

@Controller
@RequestMapping(path = "/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping(path = "/a")
	public String product() {
		return "product";
	}
}
