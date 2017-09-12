// This is for Spring PBI

package com.example.springservlet.controller;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springservlet.model.Employee;
import com.example.springservlet.repository.EmployeeJPARepository;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeJPARepository employeeJPARepository;

	@GetMapping(value = "/all") 
	public List<Employee> findAll(){
		return employeeJPARepository.findAll();
	}
	
	@GetMapping(value = "/count")
	public Integer count(){
		return (int) employeeJPARepository.count();
	}
	
	@GetMapping(value = "/{id}")
	public Employee findByName(@PathVariable long id){
		Employee employee = employeeJPARepository.findOne(id);
		
		if (employee!=null)
			return employee;
	
		return null;
	}

	@PostMapping(value = "/load")
	public Employee load(@RequestBody final Employee emp){
		Employee employee = employeeJPARepository.save(emp);
		
		if (employee!=null)
			return employee;
	
		return null;
			
	}
	
	@GetMapping(value= "/{id}/score")
	public Integer score() {
		Integer randomNum = ThreadLocalRandom.current().nextInt(0, 100);
		return randomNum;
	}
}
