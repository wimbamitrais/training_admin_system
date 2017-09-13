// This is for Spring PBI

package com.example.springservlet.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.springservlet.model.Employee;
import com.example.springservlet.repository.EmployeeJPARepository;


@RestController
@RequestMapping("/employee")
public class EmployeeController{

	@Autowired
	private EmployeeJPARepository employeeJPARepository;

	@GetMapping(value = "")
	public ModelAndView root() {
		return new ModelAndView ("redirect:/employee/all");
	}
	
	@GetMapping(value = "/all") 
	public Page<Employee> employeesPageable(Pageable pageable) {
		return employeeJPARepository.findAll(pageable);
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
	
	@GetMapping(value="/sort/{mode}")
	public List<Employee> sort(@PathVariable String mode) {
		List <Employee> employees = employeeJPARepository.findAll();
		if (mode.toLowerCase().compareTo("asc")==0) {
			employees = employees.stream().sorted((e1, e2) -> { return (int) (e1.getId() - e2.getId());}).collect(Collectors.toList());
		} else if (mode.toLowerCase().compareTo("desc")==0) {
			employees = employees.stream().sorted((e1, e2) -> { return (int) (e2.getId() - e1.getId());}).collect(Collectors.toList());
		} 
		
		return employees;
	}

}
