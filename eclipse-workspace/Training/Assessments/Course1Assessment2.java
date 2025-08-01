package Assessments;
import java.util.Scanner;
public class Course1Assessment2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number to check Even or Odd: ");
		int number = sc.nextInt();
		
		if (number % 2 == 0) {
			System.out.println(number + " is a even number.");
		} else {
			System.out.println(number + " is aa odd number.");
		}
	}
}

