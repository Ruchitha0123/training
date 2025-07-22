package wipro_keyword;

public class Command_line_arguments {
	public static void main(String[] args) {
		if(args.length<2) {
           System.out.println("Provide two numbers");
			return;
	}
	try {
		int a=Integer.parseInt(args[0]);
		int b=Integer.parseInt(args[1]);
		System.out.println("Sum = "+(a+b));
	 }catch(NumberFormatException e){
		System.out.println("invalid integer input:"+e.getMessage());
	}

 }
}