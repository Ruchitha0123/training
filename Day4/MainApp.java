package Day4;

import Day4.CreditCardPayment;
import Day4.UpiPayment;
import Day4.BillGenerator;

public class MainApp {
    public static void main(String[] args) {
        CreditCardPayment ccp = new CreditCardPayment(5000);
        ccp.makePayment();

        UpiPayment upi = new UpiPayment(1500);
        upi.makePayment();

      
        BillGenerator.displayHeader();  

        BillGenerator bill = (amount) -> {
            System.out.println("Amount: ₹" + amount);
            System.out.println("Thank you for your payment!");
        };

        bill.showBillFormat();  
        bill.generate(6500);  
        }
}