package com.practice2.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.practice2.Entity.Product;

@Service
public class ProductService {
	
	private List<Product> product = new ArrayList<Product>();
	
	public void addProduct(Product prod) {
		
		product.add(prod); 
	}
	
	public List<Product> getAll(){
		return product;
	}
	
	public Product getProductById(int id) {
		
		for(Product p: product) {
			
			if(p.getId() == id) {
				
				return p;
			}
		}
		
		return null;
	}

}
