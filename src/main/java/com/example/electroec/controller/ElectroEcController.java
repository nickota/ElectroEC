package com.example.electroec.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.electroec.entity.Cart;
import com.example.electroec.entity.Category;
import com.example.electroec.entity.Product;
import com.example.electroec.entity.ProductStatus;
import com.example.electroec.entity.Review;
import com.example.electroec.service.CartService;
import com.example.electroec.service.CategoryService;
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
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private CartService cartService;

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

		// Customers
		Integer customerId = new Integer(1);

		// Products
		Product product = productService.findFirstBySerialNum(serialNum);
		ProductStatus status = statusService.findById(product.getStatus()).orElse(null);

		// Reviews
		List<Review> reviews = reviewService.findByProductSerial(serialNum);

		// Categories
		Iterable<Category> categories = categoryService.findAll();
		Category category = categoryService.findById(product.getCategoryId()).orElse(null);

		// Cart
		List<Cart> cartDetails = cartService.findByCustomerId(customerId);
		List<Product> cartProducts = new ArrayList<Product>();
		for (Cart cartDetail : cartDetails) {
			cartProducts.add(productService.findFirstBySerialNum(cartDetail.getProductSerial()));
		}

		// Add to model
		model.addAttribute("product", product);
		model.addAttribute("status", status.getStatus());
		model.addAttribute("reviews", reviews);
		model.addAttribute("reviewCount", reviews.size());
		model.addAttribute("categories", categories);
		model.addAttribute("category", category);
		model.addAttribute("cartDetailsCount", cartDetails.size());
		model.addAttribute("cartProducts", cartProducts);
		model.addAttribute("subTotal", calculateSubTotal(cartProducts));

		return "product";
	}

	private double calculateSubTotal(List<Product> cartProducts) {

		return 1.00;
	}

}
