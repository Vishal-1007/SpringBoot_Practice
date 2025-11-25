package com.practice2.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice2.Entity.Order;
import com.practice2.Service.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/order/add")
	public String addOrder(@RequestBody Order ord) {
		orderService.addProduct(ord);
		return "Order Added Successfully";
	}
	
	@GetMapping("/order/all")
	public List<Order> getAll(){
		return orderService.getAllOrder();
	}
	
	@GetMapping("/order/{id}")
	public Order getOrderById(@PathVariable int id ) {
		
		return orderService.getOrderById(id);
	}
}
