package com.jobswitch2026.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jobswitch2026.model.Employee;
import com.jobswitch2026.repository.EmployeeRepo;

@Service
public class EmployeeService {

	EmployeeRepo repo;
	public EmployeeService(EmployeeRepo repo) {
		this.repo=repo;
	}
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		return repo.findAllEmployee();
	}
	public Employee getById(int id) {
		
		return repo.findById(id);
	}
	public Employee save(Employee e) {
		
		return repo.save(e);
	}
	
	public String delete(int id) {
		String ee=repo.deleteById(id);
		return ee;
	}

}
