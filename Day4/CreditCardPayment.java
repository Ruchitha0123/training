package Day4;

public class CreditCardPayment extends Bankpayment {
    public CreditCardPayment(double amount) {
        super(amount);
    }

    @Override
    public void makePayment() {
        System.out.println("Processing Credit Card Payment...");
        printReceipt();
    }
}
