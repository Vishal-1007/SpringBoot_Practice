package com.practice2.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice2.Entity.Student;
import com.practice2.Service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/student/add")
	public String addStudent(@RequestBody Student s) {
		studentService.addStudent(s);
		return "Student added Successfully";
		
	}
	
	@GetMapping("student/all")
	public List<Student> getAll(){
		
		return studentService.getAll();
	}
	
	@GetMapping("/student/{id}")
	public Student getStudentById(@PathVariable int id) {
		return studentService.getStudentById(id);
	}

}
