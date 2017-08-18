package training.java.pbi4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("This is example for Product Backlog 4 - java Collection Framework");

		System.out.println("\n# List of String");
		List<String> list = new ArrayList<String>();
		list.add("Wimba");
		list.add("Taufik");
		list.add("Inez");
		list.add("Yulian");
		list.add("Sopyan");
		list.add("Daniel");
		
		for (int i=0; i<list.size(); i++){
			System.out.println(list.get(i));
		}
		System.out.println("-- Remove Daniel and Sopyan");
		list.remove("Daniel");
		list.remove("Sopyan");
		for (int i=0; i<list.size(); i++){
			System.out.println(list.get(i));
		}
		
		System.out.println("\n# Set of String");
		Set<String> set = new HashSet<String>();
		set.add("Wimba");
		set.add("Taufik");
		set.add("Inez");
		set.add("Yulian");
		set.add("Sopyan");
		set.add("Daniel");

		System.out.println(set);
		
		System.out.println("-- Remove Daniel and Sopyan");
		set.remove("Daniel");
		set.remove("Sopyan");

		System.out.println(set);
		
		
		
		System.out.println("\n# Map of <Integer,String>");
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "Wimba");
		map.put(5, "Taufik");
		map.put(8, "Inez");
		map.put(3, "Yulian");
		map.put(9, "Sopyan");
		map.put(4, "Daniel");

		System.out.println(map);
		
		System.out.println("-- Remove Daniel and Sopyan");
		map.remove(4);
		map.remove(9);

		System.out.println(map);
		
	}

}
