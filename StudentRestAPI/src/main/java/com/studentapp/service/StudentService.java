package com.studentapp.service;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;

import com.studentapp.exception.StudentNotFoundException;
import com.studentapp.model.Student;

public interface StudentService {
	Student addStudent(Student student);
	List<Student> getAllStudents();
	Student getStudentByStudentId(int id) throws StudentNotFoundException;
	boolean deleteStudent(int id) throws StudentNotFoundException;
	List<Student> getStudentByCity(String city) throws StudentNotFoundException;
	List<Student> getStudentByDept(String dept) throws StudentNotFoundException;
	
}
