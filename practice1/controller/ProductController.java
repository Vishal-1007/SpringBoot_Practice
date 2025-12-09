package com.practice1.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice1.entity.Product;

@RestController
public class ProductController {
	
	@PostMapping("/productdetails")
	public String productDetails(@RequestBody Product product) {
		
		return "[" + product.getId() + ", " + product.getName()+ ", " + product.getPrice() + " ] ";
	}

}
