package com.lookup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.lookup.dao.EmployeeDAO;
import com.lookup.model.Employee;

public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	@Transactional
	public int addEmployee(Employee employee) {
		if(employee != null)
			return employeeDAO.addEmployee(employee);
		return -1;
	}

	@Override
	@Transactional
	public int updateEmployee(Employee employee) {
		if(employee != null)
			return employeeDAO.updateEmployee(employee);
		return -1;
	}

	@Override
	@Transactional
	public int deleteEmployee(int id) {
		if(id != 0)
			return employeeDAO.deleteEmployee(id);
		return -1;
	}

	@Override
	@Transactional(readOnly=true)
	public List<Employee> getAllEmployee() {
		return employeeDAO.getAllEmployee();
	}

	
}
