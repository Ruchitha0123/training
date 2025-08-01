package Day3;

public class BankMain {
	public static void main(String[] args) {
	       BankAccount account = new BankAccount("Ruchi", 1000);
	       account.deposit(500);
	       account.withdraw(300);
	       account.displayDetails();
	}

}