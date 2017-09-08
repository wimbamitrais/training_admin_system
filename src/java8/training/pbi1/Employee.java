package java8.training.pbi1;

import java.util.ArrayList;
import java.util.List;

public class Employee {
	Integer id;
	String name;
	Integer age;
	String address;
	
	public Employee(Integer id, String name, Integer age, String address){
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public static void printEmployee (Employee emp) {
		System.out.println(emp.getId()+ ". " + emp.getName() + " - " + emp.getAddress());
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	
}
