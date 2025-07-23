package Day4;
interface Payment {
    void makePayment();
}

abstract class PaymentSystem implements Payment {
    double amount;

    PaymentSystem(double amount) {
        this.amount = amount;
    }

    void showSuccessMessage() {
        System.out.println("Payment is successful: " + amount);
    }
}

class DebitCardPayment extends PaymentSystem {
    DebitCardPayment(double amount) {
        super(amount);
    }

    public void makePayment() {
        System.out.println("Debit card payment is done...");
        showSuccessMessage();
    }
}

class NetBankingPayment extends PaymentSystem {
    NetBankingPayment(double amount) {
        super(amount);
    }

    public void makePayment() {
        System.out.println("Net banking payment is done...");
        showSuccessMessage();
    }
}

public class PaymentSystems {
    public static void main(String[] args) {
        PaymentSystem ps = new DebitCardPayment(34000);
        ps.makePayment();

        System.out.println();

        PaymentSystem ps1 = new NetBankingPayment(55000);
        ps1.makePayment();
    }
}