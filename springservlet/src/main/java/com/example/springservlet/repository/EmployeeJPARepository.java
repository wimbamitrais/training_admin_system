package com.example.springservlet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.example.springservlet.model.Employee;

@Component
public interface EmployeeJPARepository extends JpaRepository<Employee, Long>{
	Employee findByFirstName(String firstName);

}
