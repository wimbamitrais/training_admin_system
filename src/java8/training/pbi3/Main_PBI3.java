package java8.training.pbi3;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main_PBI3 {
	public static void main(String[] args) {
		Predicate <Integer> isEven = (x) -> x % 2 == 0;
		System.out.println ("1. Predicate       = " + isEven.test(8));
		
		Function <Integer, String> quote = (x) -> "--- " + x + " ---"; 
		System.out.println ("2. Function        = " + quote.apply(50));
		
		BinaryOperator <Integer> multiply = (x, y) -> x * y;
		System.out.println ("3. Binary Operator = " + multiply.apply(25, 15)); 
		
		Consumer <Integer> printNumber = (x) -> System.out.println("My number is " + x); 
		System.out.print   ("4. Consumer        = "); printNumber.accept(284);
		
		Supplier <Integer> getYear = () -> { return 2017; };
		System.out.println ("5. Supplier        = " + getYear.get()); 
		
	}
}
