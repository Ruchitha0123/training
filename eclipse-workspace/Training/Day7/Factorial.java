package Day7;
import java.util.*;
public class Factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = 0;

        try {
        	System.out.print("Enter a positive integer: ");
            number = scanner.nextInt();

            if (number < 0) {
                throw new IllegalArgumentException("Number must be non-negative.");
            }

            long factorial = 1;
            for (int i = 1; i <= number; i++) {
                factorial *= i;
            }

            System.out.println("Factorial of " + number + " is: " + factorial);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Program finished executing.");
            scanner.close(); 
            
        }
    }
}