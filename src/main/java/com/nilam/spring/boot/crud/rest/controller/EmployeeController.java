package com.nilam.spring.boot.crud.rest.controller;

import java.util.List;

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

import com.nilam.spring.boot.crud.rest.model.Employee;
import com.nilam.spring.boot.crud.rest.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService service;

	@GetMapping("/v1/employees")
	public ResponseEntity<List> getAllEmployees(@RequestParam(value = "salary", required = false) Float salary) {
		List<Employee> empList = null;
		if (salary != null && salary > 0) {
			empList = service.getEmployeeWithSalary(salary);
		} else {
			empList = service.getAllEmployee();
		}
		return new ResponseEntity<List>(empList, HttpStatus.OK);
	}

	@GetMapping("/v1/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(name = "id") int id) {
		Employee employee = service.getEmployeeById(id);
		if (employee == null) {
			return new ResponseEntity<Employee>(employee, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Employee>(employee, HttpStatus.OK);
		}
	}

	@PostMapping("/v1/employees")
	public ResponseEntity<Object> addEmployee(@RequestBody Employee employee) {
		if (employee.getId() <= 0 || !service.isEmployeePresent(employee.getId())) {
			employee = service.addOrUpdateEmployee(employee);
			return new ResponseEntity<Object>(employee, HttpStatus.CREATED);
		}
		return new ResponseEntity<Object>("Employee with specified id is already present.", HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/v1/employees/{id}")
	public ResponseEntity<Employee> updateByIdOrAddEmployee(@RequestBody Employee employee,
			@PathVariable(name = "id") int id) {
		if (service.isEmployeePresent(id)) {
			employee.setId(id);
		}
		employee = service.addOrUpdateEmployee(employee);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

	@DeleteMapping("/v1/employees/{id}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable(name = "id") int id) {
		if (service.isEmployeePresent(id)) {
			service.deleteEmployeeById(id);
			return new ResponseEntity<String>("deleted", HttpStatus.OK);
		}
		return new ResponseEntity<String>("The employee with id = " + id + " is not present", HttpStatus.NOT_FOUND);
	}
}
