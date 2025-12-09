package com.practice2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice2.Entity.Employee;
import com.practice2.Service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/employee/add")
	public String addEmployee(@RequestBody Employee emp) {
		employeeService.addEmployee(emp);
		return "Employee Added Successfully";
	}
	
	@GetMapping("/employee/all")
		public List<Employee> getAll(){
			return employeeService.getAll();
		}
	
	@GetMapping("/employee/{id}")
	public Employee getEmployeeById(@PathVariable int id) {
		return employeeService.getEMployeeById(id);
	}

}
