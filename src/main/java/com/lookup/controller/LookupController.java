package com.lookup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lookup.model.Employee;
import com.lookup.service.EmployeeService;
import com.lookup.web.vo.EmployeeRequest;

@Controller
public class LookupController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value="admin/addEmployee",method=RequestMethod.POST,consumes="application/json",produces="application/json")
	public ResponseEntity<String> addEmployee(@RequestBody EmployeeRequest emp){
		if(emp == null){
			return null;
		}
		Employee employee = new Employee();
		employee.setAge(emp.getAge());
		employee.setEmail(emp.getEmail());
		employee.setName(emp.getName());
		int result = employeeService.addEmployee(employee);
		if(result == 1)
			return new ResponseEntity<String>("Added", HttpStatus.OK);
		else
			return new ResponseEntity<String>("Exception Occurs", HttpStatus.OK);
		
	}
	
	@RequestMapping(value="admin/deleteEmployee",method=RequestMethod.POST,consumes="application/json",produces="application/json")
	public ResponseEntity<String> deleteEmployee(@RequestBody Integer id){
		if(id == 0){
			return null;
		}
		int result = employeeService.deleteEmployee(id);
		if(result == 1)
			return new ResponseEntity<String>("Deleted", HttpStatus.OK);
		else
			return new ResponseEntity<String>("Exception Occurs", HttpStatus.OK);
		
	}
	
	@RequestMapping(value="admin/updateEmployee",method=RequestMethod.POST,consumes="application/json",produces="application/json")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee emp){
		if(emp == null)
			return null;
		int result = employeeService.updateEmployee(emp);
		if(result == 1)
			return new ResponseEntity<String>("Updated", HttpStatus.OK);
		else
			return new ResponseEntity<String>("Exception Occurs", HttpStatus.OK);
	}
	
	@RequestMapping(value="admin/getAllEmployees",method=RequestMethod.GET)
	public ResponseEntity<List<Employee>> getAllEmployee(){
		List<Employee> employees = employeeService.getAllEmployee();
		if(employees == null)
			return null;
		return new ResponseEntity<>(employees,HttpStatus.OK);
	}

}
