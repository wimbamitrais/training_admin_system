package java8.training.pbi4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java8.training.pbi1.Employee;

public class Main_PBI4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List <Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee(3, "Wimba Agra Wicesa", 23, "Banyuwangi"));
		employees.add(new Employee(8, "Inez Fiona", 23, "Semarang"));
		employees.add(new Employee(5, "I Gede Wisesa", 23, "Singaraja"));
		employees.add(new Employee(7, "Billy Christi Hartanto", 23, "Banjarmasin"));
		employees.add(new Employee(1, "Mohammad Taufik Andrian", 23, "Bandung"));
		employees.add(new Employee(10, "Yuliawan Rizka Syafaat", 23, "Jakarta"));
		employees.add(new Employee(6, "Sopyan Mulyana", 23, "Purwakarta"));
		employees.add(new Employee(2, "Daniel Muliawan", 23, "Denpasar"));
		employees.add(new Employee(4, "Deny Sufriawan", 23, "Denpasar"));
		employees.add(new Employee(9, "Ibnu Prayogi", 23, "Bandar Lampung"));

		System.out.println ("Unordered List");
		employees.forEach(Employee::printEmployee);

// Stream Sort Example
		System.out.println ("\nOrdered List");
		List <Employee> sorted = employees.stream()
				.sorted((e1, e2) -> { return (e1.getId() - e2.getId());})
				.collect(Collectors.toList());
		sorted.stream().forEach((employee) -> System.out.println(employee.getId() + ". " + employee.getName() + " - " + employee.getAddress()));
		System.out.println();
		sorted.forEach(Employee::printEmployee);
	}
}


