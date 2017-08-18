package training.java.pbi7;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("This is example for Product Backlog 7 - Thread");
		
		MyThread R1 = new MyThread( "First Thread");
	    R1.start();
	      
	    MyThread R2 = new MyThread( "Second Thread");
	    R2.start();
	}

}
