package com.practice1.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice1.entity.Person;

@RestController
public class PersonController {
	
	@PostMapping("/person")
	public String details(@RequestBody Person p) {
		
		return "Name is: " + p.getName() + " and his email-id is: " + p.getEmail();
	}

}
