package com.practice1.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice1.entity.Validation;

@RestController
public class ValidationController {
	
	@PostMapping("credential")
	public String credential(@RequestBody Validation validation) {
		
		if(validation.getId().equals("admin")  && validation.getPassword().equals("password") ) {
			
			return " Login successful";
		}
		
		else {
			return " Incorrect Credentials";
		}
		
		
	}

}
