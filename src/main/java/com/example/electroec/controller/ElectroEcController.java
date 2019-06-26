package com.example.electroec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ElectroEcController {

	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	@RequestMapping("/store")
	public String store() {
		return "store";
	}
	
	@RequestMapping("/")
	public String home(Model model) {
		return "redirect:index";
	}
}
