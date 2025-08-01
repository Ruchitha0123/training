package Day6;

interface Calculator_Interface{
	double subtract(double a,double b);
	default double addition(double a,double b) {
		return a+b;
	}
	static double multiply(double a,double b) {
		return a*b;
	}
	
}

class Calculator_subtract implements Calculator_Interface{
	public double subtract(double a,double b) {
		return a-b;
	}
	
}

public class CalculationInterfaceMain{
	public static void main(String[] args) {
		Calculator_Interface ci = new Calculator_subtract();
		System.out.println(ci.subtract(3.0,4.0));
		System.out.println(ci.addition(6.0, 2.0));
		System.out.println(Calculator_Interface.multiply(6,4));
	}
}
