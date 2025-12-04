package com.microservices1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeControllerApi {
	
	@GetMapping("/welcome")
	public String getMessage() {
		return "Welcome..!!";
	}

}
