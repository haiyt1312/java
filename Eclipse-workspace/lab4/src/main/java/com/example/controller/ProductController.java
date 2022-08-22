package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.service.ProductService;

@Controller
@RequestMapping("products")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@GetMapping("list")
	public String list(Model model) {
		model.addAttribute("products", productService.finAll());
		
		return "products/list";
	}
}
