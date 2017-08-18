package training.java.pbi2;

import training.java.pbi2.Elephant;
import training.java.pbi2.Employee;
import training.java.pbi2.Trainee;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Trainee trainee1 = new Trainee("Wimba", 23, "Banyuwangi");
		Trainee trainee2 = new Trainee("Taufik", 23, "Bandung");
		
		System.out.println("This is example for Product Backlog 2 - OOP");
		
		// Instance class to object
		System.out.println();
		System.out.println("# Instance of Trainee.class");
		System.out.println("Trainee 1: " + trainee1.getName() + " " + trainee1.age + " " + trainee1.address);
		System.out.println("Trainee 2: " + trainee2.getName() + " " + trainee2.age + " " + trainee2.address);
	
		// Instance inherit class to object
		System.out.println();
		System.out.println("# Instance of Employee.class (Inheritance from Trainee.class)");
		Employee employee = new Employee("Wimba", 23, "Banyuwangi");
		System.out.println("Trainee 1: " + employee.getName() + " " + employee.age + " " + employee.address);

		// Instance from Interface class
		System.out.println();
		System.out.println("# Interface from Animal.class");
		Elephant bono = new Elephant();
		bono.eat();
		bono.travel();
	}

}
