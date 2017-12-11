package com.oleksii.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.oleksii.data.domain.Student;

public interface StudentRepository extends CrudRepository<Student, Integer>{
	
}
