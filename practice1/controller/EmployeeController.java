package com.practice1.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice1.entity.Employee;
import com.practice1.entity.User;

@RestController
public class EmployeeController {
	
	
	@PostMapping("/student")
	public String saveStudent(@RequestBody User s) {
		return "Information saved successfully: " + s.getName() + "from " + s.getRole();
	}
	
	@GetMapping("/employee")
	public List<Employee> getEmployees(){
		
		List<Employee> list = new ArrayList<Employee>();
		list.add(new Employee(1, "Vishal"));
		list.add(new Employee(2, "Rohan"));
		list.add(new Employee(3, "Ronny"));
		
		return list;
	}
	
	@GetMapping("/add{a}/{b}")
	public String add(@PathVariable int a, @PathVariable int b) {
		return "Sum = " + (a+b);
	}

}
