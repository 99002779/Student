package com.studentapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.studentapp.dao.StudentRepository;
import com.studentapp.exception.StudentNotFoundException;
import com.studentapp.model.Student;
@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentRepository studentRepository;
	@Override
	public Student addStudent(Student student) {
		// TODO Auto-generated method stub
		Student student1=studentRepository.save(student);
		return student1;
	}

	@Override
	public Student getStudentByStudentId(int id) throws StudentNotFoundException {
		// TODO Auto-generated method stub
		return studentRepository.findById(id).orElseThrow(()-> new StudentNotFoundException("Id not available"));
	}

	@Override
	public boolean deleteStudent(int id) throws StudentNotFoundException {
		// TODO Auto-generated method stub
		studentRepository.deleteById(id);
		return true;
	}

	@Override
	public List<Student> getStudentByCity(String city) throws StudentNotFoundException {
		// TODO Auto-generated method stub
		return studentRepository.findByAddressCity(city);
	}

	@Override
	public List<Student> getStudentByDept(String dept) throws StudentNotFoundException {
		// TODO Auto-generated method stub
		return studentRepository.findByDepartment(dept);
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}



}
