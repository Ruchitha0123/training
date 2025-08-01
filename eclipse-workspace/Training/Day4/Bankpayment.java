package Day4;

public abstract class Bankpayment {
	    protected double amount;

	    public Bankpayment(double amount) {
	        this.amount = amount;
	    }

	    public void printReceipt() {
	        System.out.println("Payment of ₹" + amount + " processed.");
	    }

	    public abstract void makePayment();
}
