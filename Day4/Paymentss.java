package Day4;

abstract class Payments
{
	double amount;
	
	Payments(double amount)
	
	{
		this.amount=amount;	
	}
	abstract void makePayment();
	  
	void showSuccessMessage()
	{
		System.out.println("Payment Sucessfull" +amount);
	}

}
class creditCardPayment extends Payments
{
	creditCardPayment(double amount)
	{
		super(amount);
	}
	void makePayment()
	{
		System.out.println("credit Card payment is done..");
	}
}
class upiPayment extends Payments
{
	upiPayment(double amount)
	{
		super(amount);
	}
	void makePayment()
	{
		System.out.println("upiPayment is done..");
	}
  
}
public class Paymentss
{
	    public static void main(String[] args) 
	    {
		      Payments py=new creditCardPayment(4500);
		      py.makePayment();
		      System.out.println("Creditcard payment is done");
		      Payments py2=new upiPayment(3000);
		      py2.makePayment();
		      System.out.println("upi payment is done");
		
		 
	     }
}