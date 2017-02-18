package com.lookup.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lookup.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	@Query("SELECT e FROM Employee e")
	public List<Employee> getAllEmployee();
	
	@Query("SELECT e FROM Employee e where e.id=:id")
	public Employee getEmployeeId(@Param("id") int id);
	

}
