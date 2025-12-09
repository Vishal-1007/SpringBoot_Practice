package com.practice1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.practice1.entity.User;

@RestController
public class UserController {
	
	@GetMapping("/view")
	public User userInfo() {
		return new User("Vishal ","Full Stack Developer");
	}
	
	@GetMapping("/greet/{name}")
	public String greet(@PathVariable String name) {
		return "Hello Mr. "+ name + "!!";
	}

	
}
