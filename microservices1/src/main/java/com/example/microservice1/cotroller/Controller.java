package com.example.microservice1.cotroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vi/employee")
public class Controller {
	
	@GetMapping("/message")
	public String getMessage() {
		return "your Message";
		
	}

}
