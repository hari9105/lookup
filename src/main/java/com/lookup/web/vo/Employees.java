package com.lookup.web.vo;

import java.util.List;

import com.lookup.model.Employee;

public class Employees {
	
	private List<Employee> employee;

	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Employees [employee=" + employee + "]";
	}
	
	

}
