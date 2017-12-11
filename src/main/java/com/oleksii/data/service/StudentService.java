package com.oleksii.data.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oleksii.data.domain.Student;
import com.oleksii.data.repository.StudentRepository;

@Service
public class StudentService {
	
	private StudentRepository studentRepository;
	
	@Autowired
	public StudentService(StudentRepository studentRepository){
		this.studentRepository = studentRepository;		
	}

	public void addAll(List<Student> students) {
		students.forEach(s -> studentRepository.save(s));
	}

	public List<Student> findAll() {
		List<Student> result = new ArrayList<>();
		studentRepository.findAll().forEach(s -> result.add(s));
		return result;
	}
		
}
