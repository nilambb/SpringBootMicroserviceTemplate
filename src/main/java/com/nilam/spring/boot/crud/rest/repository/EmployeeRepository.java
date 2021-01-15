package com.nilam.spring.boot.crud.rest.repository;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.nilam.spring.boot.crud.rest.model.Employee;

@Component
public class EmployeeRepository {
	private Map<Integer, Employee> empData = new HashMap();

	public EmployeeRepository() {
		empData.put(1, new Employee(1, "emp-1", "emp-1@gmail.com", 1111));
		empData.put(2, new Employee(2, "emp-2", "emp-2@gmail.com", 2222));
		empData.put(3, new Employee(3, "emp-3", "emp-3@gmail.com", 3333));
		empData.put(4, new Employee(4, "emp-4", "emp-4@gmail.com", 4444));
		empData.put(5, new Employee(5, "emp-5", "emp-5@gmail.com", 5555));
	}

	public List<Employee> getAllEmployees() {
		return empData.values().stream().collect(Collectors.toList());
	}

	public Employee getEmployeeById(int id) {
		return empData.get(id);
	}

	public Employee addUpdateEmployee(Employee employee) {
		if (employee.getId() <= 0) {
			int max = java.util.Collections.max(empData.keySet());
			employee.setId(++max);
		}
		return empData.put(employee.getId(), employee);
	}

	public Employee deleteEmployee(int id) {
		return empData.remove(id);
	}

	public boolean isEmployeePresent(int id) {
		return empData.containsKey(id);
	}

	public List<Employee> getEmployeesBySalary(final float salary) {
		return empData.values().stream().filter(e -> e.getSalary() == salary).collect(Collectors.toList());
	}
}
