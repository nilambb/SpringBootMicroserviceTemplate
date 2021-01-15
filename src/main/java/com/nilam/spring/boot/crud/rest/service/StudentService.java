package com.nilam.spring.boot.crud.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nilam.spring.boot.crud.rest.entity.Student;
import com.nilam.spring.boot.crud.rest.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	StudentRepository studentRepository;

	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	public Optional<Student> getStudentById(long id) {
		return studentRepository.findById(id);
	}
	
	public List<Student> getStudentByCity(String city) {
		return studentRepository.findByCity(city);
	}

	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}
	
	public void deleteById(Long id) {
		studentRepository.deleteById(id);
	}
}
