package com.example.demo.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Student;

public interface StudentRepository 
	extends CrudRepository<Student, Integer> // T = Entity Class Name, ID = PK DataType (@Id)
{
	
}
