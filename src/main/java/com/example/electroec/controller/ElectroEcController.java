package com.example.electroec.controller;

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
import com.example.electroec.entity.Review;
import com.example.electroec.service.CartService;
import com.example.electroec.service.CategoryService;
import com.example.electroec.service.ProductService;
import com.example.electroec.service.ReviewService;

@Controller
public class ElectroEcController {

	@Autowired
	private ProductService productService;
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
		Product product = productService.findOne(serialNum);

		// Reviews
		List<Review> reviews = reviewService.findAll(serialNum);

		// Categories
		Iterable<Category> categories = categoryService.findAll();

		// Cart
		List<Cart> cart = cartService.findAll(customerId);

		// Add to model
		model.addAttribute("product", product);
		model.addAttribute("status", product.getStatus().getName());
		model.addAttribute("reviews", reviews);
		model.addAttribute("reviewCount", reviews.size());
		model.addAttribute("categories", categories);
		model.addAttribute("productCategory", product.getCategory().getName());
		model.addAttribute("totalQuantity", totalQuantity(cart));
		model.addAttribute("cart", cart);
		model.addAttribute("subTotal", calculateSubTotal(cart));

		return "product";
	}

	private int totalQuantity(List<Cart> cart) {
		int totalQuantity = 0;
		for (Cart cartInfo : cart) {
			totalQuantity = +cartInfo.getQuantity();
		}
		return totalQuantity;
	}

	private double calculateSubTotal(List<Cart> cart) {
		double subTotal = 0.00;
		for (Cart cartInfo : cart) {
			subTotal += cartInfo.getProduct().getPrice() * cartInfo.getQuantity();
		}
		return subTotal;
	}

}
