package training.java.pbi3;

import java.math.BigDecimal;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer num1;
		Integer num2;
		BigDecimal bigDecimal;
		String text;
		char character;
		String[] trainee = {"Wimba", "Taufik", "Inez", "Yuliawan"};
		Boolean bool = Boolean.TRUE;
		

		System.out.println("This is example for Product Backlog 3 - Languange Fundamental");
		System.out.println();
		
		System.out.println("List Trainee");
		if (bool){
			for (int i=0; i<trainee.length; i++){
				System.out.println("Traine " + i + ": " + trainee[i]);
			}
		} else {
			System.out.println("List is empty");
		}
		
		// Try catch

        System.out.println();
        System.out.println("Try catch");
		 try { 
	        // Try block to handle code that may cause exception
	        num1 = 0;
	        num2 = 62 / num1;
	        System.out.println("Try block message");
	     } catch (ArithmeticException e) { 
	            // This block is to catch divide-by-zero error
	            System.out.println("Error: Don't divide a number by zero");
	     }
		 
		 System.out.println("End of try catch");
		 
	}

}
