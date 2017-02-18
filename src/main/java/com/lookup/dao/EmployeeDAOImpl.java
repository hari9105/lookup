package com.lookup.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import com.lookup.dao.repository.EmployeeRepository;
import com.lookup.model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	@Autowired
	private EntityManager em;
	
	@Autowired
	private EmployeeRepository empRepos;

	@Override
	public int addEmployee(Employee employee) {
		em.persist(employee);
		return 1;
	}

	@Override
	public int deleteEmployee(Integer id) {
		Employee emp = empRepos.getEmployeeId(id);
		if(emp!=null){
			em.remove(emp);
			return 1;
		}
		return -1;
	}

	@Override
	public int updateEmployee(Employee employee) {
		int id = employee.getId();
		if(id==0) return -1;
		Employee empOld = empRepos.getEmployeeId(id);
		if(empOld != null){
			empOld.setAge(employee.getAge());
			empOld.setEmail(employee.getEmail());
			empOld.setName(employee.getName());
			return 1;
		}
		return -1;
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> emps = empRepos.getAllEmployee();
		return emps;
	}

}
