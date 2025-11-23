package com.practice1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckNumController {
	
	@GetMapping("/check/{num}")
	public String checkNum(@PathVariable int num) {
		
		if(num % 2 == 0) {
			
			return num + " is an Even Number";
		}
		
		else {
			
			return num + " is a Odd Number";
		}
	}

}
