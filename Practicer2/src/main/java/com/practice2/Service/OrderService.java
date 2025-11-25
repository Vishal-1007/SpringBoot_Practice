package com.practice2.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.practice2.Entity.Order;

@Service
public class OrderService {
	
	private List<Order> order = new ArrayList<Order>();
	
	public void addProduct( Order ord) {
		
		order.add(ord);	
	}
	
	public List<Order> getAllOrder(){
		
		return order;
	}
	
	public Order getOrderById(int id) {
		
		for(Order o: order) {
			
			if(o.getId() == id) {
				
				return o;
			}
		}
		
		return null;
	}
	

}
