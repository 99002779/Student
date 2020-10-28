package com.studentapp.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.studentapp.exception.StudentNotFoundException;
import com.studentapp.model.Student;
@Repository
public interface StudentRepository extends MongoRepository<Student, Integer>{
	List<Student> findByAddressCity(String city) throws StudentNotFoundException;
	List<Student> findByDepartment(String dept) throws StudentNotFoundException;
	
}
