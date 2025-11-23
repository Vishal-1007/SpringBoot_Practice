package com.practice1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductNumController {
	
	@GetMapping("/prod/{a}/{b}")
	public String findProduct(@PathVariable int a, @PathVariable int b) {
		
		int product = a * b;
		
		return " Product of the given number is: " + product ;
	}

}
