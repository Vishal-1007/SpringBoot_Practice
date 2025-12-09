package com.practice2.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.practice2.Entity.Student;

@Service
public class StudentService {
	
	private List<Student> student = new ArrayList<Student>();
	
	public void addStudent(Student s) {
		student.add(s);
	}
	
	public List<Student> getAll(){
		
		return student;
	}
	
	public Student getStudentById(int id) {
		for(Student s: student) {
			
			if(s.getId() == id) {
				return s;
			}
		}
		
		return null;
	}

}
