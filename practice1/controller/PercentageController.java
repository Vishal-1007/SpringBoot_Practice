package com.practice1.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice1.entity.Percentage;

@RestController
public class PercentageController {
	
	@PostMapping("/percentage")
	public String studentPercentage(@RequestBody Percentage percentage) {
		
		int total = percentage.getMarks1() + percentage.getMarks2() + percentage.getMarks3();
		
		int per = total / 3;
		
		return "Total =  " + total + " Percentage =  " + per;
		
	}

}
