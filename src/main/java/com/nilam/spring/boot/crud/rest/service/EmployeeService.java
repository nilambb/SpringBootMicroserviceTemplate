package com.nilam.spring.boot.crud.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nilam.spring.boot.crud.rest.model.Employee;
import com.nilam.spring.boot.crud.rest.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository empRepo;

	public List<Employee> getAllEmployee() {
		return empRepo.getAllEmployees();
	}

	public Employee getEmployeeById(int id) {
		return empRepo.getEmployeeById(id);
	}

	public List<Employee> getEmployeeWithSalary(float salary) {
		return empRepo.getEmployeesBySalary(salary);
	}

	public boolean deleteEmployeeById(int id) {
		if (empRepo.isEmployeePresent(id)) {
			empRepo.deleteEmployee(id);
			return false;
		} else {
			return true;
		}
	}
	
	public Employee addOrUpdateEmployee(Employee employee) {
		return empRepo.addUpdateEmployee(employee);
	}
	
	public boolean isEmployeePresent(int id) {
		return empRepo.isEmployeePresent(id);
	}

}
