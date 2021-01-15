package com.nilam.spring.boot.crud.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nilam.spring.boot.crud.rest.entity.Student;
import com.nilam.spring.boot.crud.rest.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	StudentService studentService;

	@GetMapping("/v1/students")
	public ResponseEntity<List> getAllStudents(@RequestParam(name = "city", required = false) String city) {
		if (null != city) {
			return new ResponseEntity<List>(studentService.getStudentByCity(city), HttpStatus.OK);
		}
		return new ResponseEntity<List>(studentService.getAllStudents(), HttpStatus.OK);
	}

	@GetMapping("/v1/students/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable(name = "id") Long id) {
		Optional<Student> student = studentService.getStudentById(id);
		if (student.isPresent()) {
			return new ResponseEntity<Student>(student.get(), HttpStatus.OK);
		}
		return new ResponseEntity(null, HttpStatus.NOT_FOUND);
	}

	@PostMapping("/v1/students")
	public ResponseEntity<Object> saveStudent(@RequestBody Student student) {
		if (null != student.getId() && studentService.getStudentById(student.getId()).isPresent()) {
			return new ResponseEntity<Object>("Student with provided id is already present!", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Object>(studentService.saveStudent(student), HttpStatus.CREATED);

	}
	
	@PutMapping("/v1/students/{id}")
	public ResponseEntity<Student> updateStudentById(@PathVariable(name = "id") Long id, @RequestBody Student student) {
		student.setId(id);
		return new ResponseEntity(studentService.saveStudent(student), HttpStatus.OK);
	}
	
	@DeleteMapping("/v1/students/{id}")
	public ResponseEntity<String> deleteStudentById(@PathVariable(name = "id") Long id) {
		if(studentService.getStudentById(id).isPresent()) {
			studentService.deleteById(id);
			return new ResponseEntity<String>("deleted", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Student with specified id is not present can not delete.", HttpStatus.NOT_FOUND);
	}
}
