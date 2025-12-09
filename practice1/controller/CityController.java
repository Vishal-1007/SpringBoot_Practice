package com.practice1.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice1.entity.City;

@RestController
public class CityController {
	
	@GetMapping("/details")
	public List<City> getCities(){
		
		List<City> list = new ArrayList<>();
		
		list.add(new City ("Delhi"));
		list.add(new City("Mumbai"));
		list.add(new City("Bengaluru"));
		list.add(new City("Ahemdabad"));
		
		return list;
	}

}
