package com.java.springboot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.java.springboot.entity.Employee;

@Service
public interface EmployeeService {
	
	Employee getEmployee(int id);
	List<Employee> getAllEmployees();
	Employee saveEmployee(Employee e);
	Employee updateEmployee(int id, Employee empDetails);
	void deleteEmployee(int id);

}
