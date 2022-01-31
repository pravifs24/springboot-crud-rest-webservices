package com.java.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.java.springboot.entity.Employee;
import com.java.springboot.exception.ResourceNotFoundExcetion;
import com.java.springboot.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepo;

	@Override
	public List<Employee> getAllEmployees() {
		
		return employeeRepo.findAll();
	}

	@Override
	public Employee saveEmployee(Employee e) {
		
		return employeeRepo.save(e);
		
	}

	@Override
	public Employee getEmployee(int id) {
		
		Employee employee = employeeRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExcetion("Employee with id "+id+" not exist"));
		return employee;
	
	}

	@Override
	public Employee updateEmployee(int id, Employee empDetails) {
		Employee employee = employeeRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExcetion("Employee with id "+id+" is not exist to update"));
		employee.setFirstName(empDetails.getFirstName());
		employee.setLastName(empDetails.getLastName());
		employee.setEmailId(empDetails.getEmailId());
		
		Employee updatedEmployee = employeeRepo.save(employee);
		return updatedEmployee;
	}

	@Override
	public void deleteEmployee(int id) {
		
		Employee employee = employeeRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExcetion("Employee with id "+id+" is not Exist"));
		employeeRepo.delete(employee);
			
	}

}
