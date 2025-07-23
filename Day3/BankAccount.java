package Day3;

public class BankAccount {
	private String accountHolder;
	   private double balance;
	   // Constructor- Initialise the Objects
	   public BankAccount(String accountHolder, double initialBalance) {
	       this.accountHolder = accountHolder;
	       this.balance = initialBalance;
	   }
	   // Deposit method
	   public void deposit(double amount) {
	       balance += amount;
	       System.out.println(amount + " deposited. New Balance: " + balance);
	   }
	   // Withdraw method
	   public void withdraw(double amount) {
	       if (amount > balance) {
	           System.out.println("Insufficient balance.");
	       } else {
	           balance -= amount;
	           System.out.println(amount + " withdrawn. Remaining Balance: " + balance);
	       }
	   }
	   // Display account details
	   public void displayDetails() {
	       System.out.println("Account Holder: " + accountHolder);
	       System.out.println("Balance: " + balance);
	   }
}
