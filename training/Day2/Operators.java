package Day2;

public class Operators {
	    public static void main(String[] args) {
	        int a = 10, b = 5;

	      
	        System.out.println("Sum: " + (a + b));
	        System.out.println("Product: " + (a * b));

	       
	        System.out.println("Is a greater than b? " + (a > b));

	        boolean condition = (a > b) && (a != b);
	        System.out.println("Logical AND result: " + condition);
	    }
}