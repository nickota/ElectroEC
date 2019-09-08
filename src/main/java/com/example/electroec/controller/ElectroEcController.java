package com.example.electroec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.electroec.entity.Cart;
import com.example.electroec.entity.Category;
import com.example.electroec.entity.Product;
import com.example.electroec.entity.Review;
import com.example.electroec.entity.User;
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

	// User
	// TODO:input user information
	User user = new User();

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

		// Products
		Product product = productService.findOne(serialNum);
		// Reviews
		List<Review> reviews = reviewService.findAll(serialNum);
		// Categories
		Iterable<Category> categories = categoryService.findAll();
		// Cart
		List<Cart> cart = cartService.findAll(user);

		// Add to model
		model.addAttribute("product", product);
		model.addAttribute("status", product.getStatus().getName());
		model.addAttribute("reviews", reviews);
		model.addAttribute("reviewCount", reviews.size());
		model.addAttribute("categories", categories);
		model.addAttribute("productCategory", product.getCategory().getName());
		model.addAttribute("cart", cart);
		model.addAttribute("totalQuantity", totalQuantity(cart));
		model.addAttribute("subTotal", calculateSubTotal(cart));

		return "product";
	}

	@RequestMapping(path = "/product/{serialNum}/addToCart")
	@PostMapping
	@Transactional(readOnly = false)
	public String addToCart(@PathVariable String serialNum) {
		List<Cart> cartInfos = cartService.findAll(user);
		Integer quantity = new Integer(1);
		if (cartInfos.isEmpty()) {
			cartService.insert(productService.findOne(serialNum), quantity);
		}

		for (Cart cartInfo : cartInfos) {
			if (cartInfo.getProduct().getSerialNum().equals(serialNum)) {
				cartService.update(productService.findOne(serialNum), quantity);
			}
		}

		return "redirect:/product/{serialNum}";
	}

	// Calculates the total quantity included in the cart.
	private int totalQuantity(List<Cart> cart) {
		int totalQuantity = 0;
		for (Cart cartInfo : cart) {
			totalQuantity += cartInfo.getQuantity();
		}
		return totalQuantity;
	}

	// Calculates the subtotal to show on cart.
	private double calculateSubTotal(List<Cart> cart) {
		double subTotal = 0.00;
		for (Cart cartInfo : cart) {
			subTotal += cartInfo.getProduct().getPrice() * cartInfo.getQuantity();
		}
		return subTotal;
	}

}
