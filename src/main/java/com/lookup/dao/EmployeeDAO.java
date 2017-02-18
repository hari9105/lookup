package com.lookup.dao;

import java.util.List;

import com.lookup.model.Employee;

public interface EmployeeDAO {
	
	public int addEmployee(Employee employee);
	
	public int deleteEmployee(Integer id);
	
	public int updateEmployee(Employee employee);
	
	public List<Employee> getAllEmployee();

}
