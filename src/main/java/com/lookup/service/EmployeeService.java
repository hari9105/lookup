package com.lookup.service;

import java.util.List;

import com.lookup.model.Employee;

public interface EmployeeService {

	public int addEmployee(Employee employee);
	
	public int updateEmployee(Employee employee);
	
	public int deleteEmployee(int id);
	
	public List<Employee> getAllEmployee();
	
	
}
