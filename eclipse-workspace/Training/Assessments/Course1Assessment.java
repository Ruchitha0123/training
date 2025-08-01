package Assessments;

public class Course1Assessment {
	public static void main(String[] args) {
		int intValue = 10;
		double doubleValue = intValue;
		System.out.println("Implicit type casting (Widening Conversion):");
		System.out.println("int :" + intValue);
		System.out.println("double: " + doubleValue);
		
		double anotherDoubleValue = 15.75;
		int anotherIntValue = (int) anotherDoubleValue;
		System.out.println("\nExplicit type Casting (Narrowing Conversion):");
		System.out.println("double: "+ anotherDoubleValue);
		System.out.println("int: " + anotherIntValue );
	}
}

