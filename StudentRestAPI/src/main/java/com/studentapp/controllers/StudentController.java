package com.studentapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentapp.exception.StudentNotFoundException;
import com.studentapp.model.Student;
import com.studentapp.service.StudentService;

@RestController
@RequestMapping("student-api")
public class StudentController {
	@Autowired
	StudentService studentService;
	@GetMapping("/students")
	List<Student> getAllStudents(){
		return studentService.getAllStudents();
	}
	@PostMapping("/students")
	ResponseEntity<Student> addStudent(@RequestBody Student student) {
		Student nstudent= studentService.addStudent(student);
		return ResponseEntity.ok(nstudent);
	}
	@GetMapping("/student-by-id/{id}")
	ResponseEntity<Student> getStudentById(@PathVariable("id")int id){
		Student student=studentService.getStudentByStudentId(id);
		return ResponseEntity.ok(student);
	}
	@GetMapping("/students-by-dept/{dept}")
	ResponseEntity<List<Student>> getStudentByDept(@PathVariable("dept")String dept){
		List<Student> students=studentService.getStudentByDept(dept);
		return ResponseEntity.ok(students);
	}
	@GetMapping("/students-by-city/{city}")
	ResponseEntity<List<Student>> getStudentByCity(@PathVariable("city")String city){
		List<Student> students=studentService.getStudentByCity(city);
		return ResponseEntity.ok(students);
	}
	@GetMapping("/delete-one/{id}")
	boolean deleteStudent(@PathVariable("id")int id) throws StudentNotFoundException{
		studentService.deleteStudent(id);
		return true;
	}
}
