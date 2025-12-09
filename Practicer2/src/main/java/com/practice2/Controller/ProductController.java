package com.practice2.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice2.Entity.Product;
import com.practice2.Service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/product/add")
	public String addProduct(@RequestBody Product prod) {
		productService.addProduct(prod);
		return "Product added successfully";
	}
	
	@GetMapping("product/all")
	public List<Product> getAll() {
		
		return productService.getAll();
		
	}
	
	@GetMapping("product/{id}")
	public Product getEmoployeeById(@PathVariable int id) {
		return productService.getProductById(id);
	}

}
