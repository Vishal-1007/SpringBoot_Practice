package com.practice1.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice1.entity.Math;

@RestController
public class MathController {
	
	@PostMapping("/sum")
	public String sumOfNumbers(@RequestBody Math number) {
		int sum = number.getA() + number.getB();
		return "sum = " +  sum;
	}

}
