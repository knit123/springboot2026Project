package com.jobswitch2026.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobswitch2026.model.Employee;
import com.jobswitch2026.service.EmployeeService;



@RestController
@RequestMapping
public class EmployeeController {
	
	EmployeeService service;
	public EmployeeController(EmployeeService service) {
		this.service=service;
	}
	@GetMapping("/employee")
	public String welcomeAdmin(){
		
		return "Welcome java developer !!";
		
	}
	
	@GetMapping("/employee/all")
	public List<Employee> getAllEmployee(){
		
		return service.getAll();
		
	}
 @GetMapping("/employee/get/{id}")
   public Employee getEmpById(@PathVariable int id){
		
		return service.getById(id);
		
	}

   @PostMapping("/employee/add")
   public Employee addEmployee(@RequestBody Employee e){
		
		return service.save(e);
		
	}
   @DeleteMapping("/employee/delete/{id}")
   public String deleteById(@PathVariable int id){
		
		return service.delete(id);
		
	}

}
