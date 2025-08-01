package wipro_keyword;

public class Calculator_RuntimeData {
	public int add(int b,int c) {
		return b+c;
	}
public static void main(String[] args) {
	Calculator_RuntimeData calc=new Calculator_RuntimeData();
	int sum=calc.add(6, 8);
	System.out.println("Sum = "+sum);
	
}
}
