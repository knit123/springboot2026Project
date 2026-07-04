package com.jobswitch2026.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;
import com.jobswitch2026.model.Employee;

@Repository
public class EmployeeRepo {

public static List<Employee> empList =new ArrayList<>();

   
	
	public List<Employee> findAllEmployee() {
		
		return empList;
	}

	public Employee findById(int id) {
		
		Employee ee=empList.stream().filter(e->e.getEmpId()==id).findFirst().orElse(null);
		System.out.println("employee::"+ee);
		
		return ee;
	}

	public Employee save(Employee e) {
		empList.add(e);
		return e;
	}

	public String deleteById(int id) {
		String status;
		Employee ee=empList.stream().filter(e->e.getEmpId()==id).findFirst().orElse(null);
		if(ee!=null) {
		empList.remove(ee);
		status="Employee of Id::"+id+" is deleted";
		}else {
			status="Employee of Id "+id+" is not present";
		}
		return status;
	}

}
