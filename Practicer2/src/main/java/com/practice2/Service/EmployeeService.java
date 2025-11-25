package com.practice2.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.practice2.Entity.Employee;

@Service
public class EmployeeService {
	
	private List<Employee> employee = new ArrayList<Employee>();
	
	public void addEmployee(Employee emp) {
		
		employee.add(emp);
	}
	
	public List<Employee> getAll(){
		
		return employee;
	}
	
	public Employee  getEMployeeById(int id) {
		
		for(Employee emp: employee) {
		if(emp.getId() == id) {
			
			return emp;
		}
		
	}
		return null;
	}

}
