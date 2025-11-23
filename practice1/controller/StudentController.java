package com.practice1.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice1.entity.Student;

@RestController
public class StudentController {
	
	@PostMapping("/namecheck")
	public String saveDetails(@RequestBody Student s) {
		
		return " Data saved successfully " + s.getFirstname() + s.getLastname();
	}
}
