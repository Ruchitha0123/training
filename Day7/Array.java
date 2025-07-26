package Day7;
import java.util.Scanner;
public class Array {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50}; 
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter the index to access (0-4): ");
            int index = sc.nextInt();  
            System.out.println("Element at index " + index + ": " + numbers[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Tried to access an index outside the array.");
        } finally {
            System.out.println("This block always runs - End of program.");
            sc.close();
        }
    }
}


