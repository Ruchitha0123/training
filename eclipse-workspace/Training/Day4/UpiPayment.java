package Day4;

public class UpiPayment extends Bankpayment {
    public UpiPayment(double amount) {
        super(amount);
    }

    @Override
    public void makePayment() {
        System.out.println("Processing UPI Payment...");
        printReceipt();
    }
}