package com.example.electroec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.electroec.entity.CartItem;
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

	Integer userId = new Integer(1);

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
		Product product = productService.getOne(serialNum);
		// Reviews
		List<Review> reviews = reviewService.findAll(serialNum);
		// Categories
		Iterable<Category> categories = categoryService.findAll();
		// Cart
		List<CartItem> cartItems = cartService.findByUserId(userId);

		// Add to model
		model.addAttribute("product", product);
		model.addAttribute("status", product.getStatus().getName());
		model.addAttribute("reviews", reviews);
		model.addAttribute("reviewCount", reviews.size());
		model.addAttribute("categories", categories);
		model.addAttribute("productCategory", product.getCategory().getName());
		model.addAttribute("cartItems", cartItems);
		model.addAttribute("totalQuantity", totalQuantity(cartItems));
		model.addAttribute("subTotal", calculateSubTotal(cartItems));

		return "product";
	}

//	@RequestMapping(path = "/product/{serialNum}/addToCart")
//	@PostMapping
//	@Transactional(readOnly = false)
//	public String addToCart(@PathVariable String serialNum) {
//		Cart cart = user.getCart();
//		Integer quantity = new Integer(1);
//		if (cart == null) {
//			cartService.insert(productService.findOne(serialNum), quantity);
//		}
//
//		return "redirect:/product/{serialNum}";
//	}

	// Calculates the total quantity included in the cart.
	private int totalQuantity(List<CartItem> cartItems) {
		int totalQuantity = 0;
		for (CartItem cartItem : cartItems) {
			totalQuantity += cartItem.getQuantity();
		}
		return totalQuantity;
	}

	// Calculates the subtotal to show on cart.
	private double calculateSubTotal(List<CartItem> cartItems) {
		double subTotal = 0.00;
		for (CartItem cartItem : cartItems) {
			subTotal += productService.getOne(cartItem.getProductSerial()).getPrice() * cartItem.getQuantity();
		}
		return subTotal;
	}

}
