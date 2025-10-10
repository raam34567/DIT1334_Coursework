package chapter1;//my Package name

//Author name: Miss Diana
//Date create: 17.09.2025
//Purpose of Code: Chapter's 1 Sample Code which is a OOP Mini Project: BankSystem that Demonstrates: Encapsulation, Inheritance, Abstraction, Polymorphism

//library that being imported when necessary

//---------- ABSTRACTION via Interface ----------
interface InterestBearing 
{
	double calculateMonthlyInterest(); // hides how interest is computed
}

//---------- ABSTRACTION via Abstract Class ----------
abstract class Account {
	 // --------- ENCAPSULATION (private fields + getters/setters) ----------
	 private final String owner; //declaration for private field
	 private double balance; //declaration for private filed
	
	 protected Account(String owner, double openingBalance) { //setter
	     this.owner = owner; // to set the declared private owner with the value in the owner
	     this.balance = Math.max(0, openingBalance); // to set the declared private balanced with the value in the openingBalance
	 }
	
	 public String getOwner() //getter
	 { 
		 return owner; 
	 } 
	 
	 public double getBalance() //getter
	 { 
		 return balance; 
	 }
	
	 // Only subclasses can adjust balance directly in a controlled way
	 protected void credit(double amount) 
	 { 
		 balance += amount; 
	 }
	 
	 protected boolean debit(double amount) {
	     if (amount <= 0 || amount > balance) return false;
	     balance -= amount;
	     return true;
	 }
	
	 // Common behavior
	 public void deposit(double amount) {
	     if (amount <= 0) {
	         System.out.println("Deposit must be positive.");
	         return;
	     }
	     credit(amount);
	     System.out.println(accountType() + " | " + owner + " deposited RM" + amount);
	 }
	
	 // --------- POLYMORPHISM (overloading) ----------
	 public void deposit(double amount, String note) {
	     deposit(amount);
	     System.out.println("Note: " + note);
	 }
	
	 public boolean withdraw(double amount) {
	     boolean ok = debit(amount);
	     System.out.println(accountType() + " | " + owner + (ok ? " withdrew RM" + amount : " withdrawal failed"));
	     return ok;
	 }
	
	 // Force subclasses to specify fees/type (abstract = ABSTRACTION)
	 public abstract double monthlyCharge();
	 public abstract String accountType();
	
	 public void applyMonthlyCharge() 
	 {
	     double fee = monthlyCharge();
	     if (fee > 0 && fee <= getBalance()) {
	         debit(fee);
	         System.out.println(accountType() + " | Monthly fee RM" + fee + " applied.");
	     } else if (fee > 0) {
	         System.out.println(accountType() + " | Insufficient balance to apply fee RM" + fee);
	     }
	 }
	
	 public String summary() 
	 {
	     return accountType() + " | Owner: " + owner + " | Balance: RM" + String.format("%.2f", getBalance());
	 }
}

//---------- INHERITANCE: SavingsAccount extends Account ----------
class SavingsAccount extends Account implements InterestBearing {
	 private final double annualRate; // e.g., 0.06 = 6% p.a.
	
	 public SavingsAccount(String owner, double openingBalance, double annualRate) {
	     super(owner, openingBalance);
	     this.annualRate = annualRate;
	 }
	
	 @Override
	 public double monthlyCharge() { return 0.0; } // usually no fee
	
	 @Override
	 public String accountType() { return "SavingsAccount"; }
	
	 // Interest formula is hidden behind the interface (ABSTRACTION)
	 @Override
	 public double calculateMonthlyInterest() {
	     return getBalance() * (annualRate / 12.0);
	 }
	
	 // Example of POLYMORPHISM (overriding behavior)
	 @Override
	 public boolean withdraw(double amount) {
	     // Simple rule: allow withdrawal but keep at least RM20
	     if (getBalance() - amount < 20) {
	         System.out.println("SavingsAccount | Maintain minimum RM20. Withdrawal denied.");
	         return false;
	     }
	     return super.withdraw(amount);
	 }
}

//---------- INHERITANCE: CheckingAccount (a.k.a. Current) ----------
class CheckingAccount extends Account 
{
	 private final double monthlyFee;
	
	 public CheckingAccount(String owner, double openingBalance, double monthlyFee) 
	 {
	     super(owner, openingBalance);
	     this.monthlyFee = monthlyFee;
	 }
	
	 @Override
	 public double monthlyCharge() 
	 { 
		 return monthlyFee; 
	 }
	
	 @Override
	 public String accountType() 
	 { 
		 return "CheckingAccount"; 
	 }
}
	
	//---------- POLYMORPHISM in action ----------
	public class BankSystemDemo 
	{
		 // A helper that accepts the parent type (Account) and calls methods.
		 // The actual method implementations run based on the real object type.
		 private static void printAccountSummary(Account acc) 
		 {
		     System.out.println(acc.summary());
		 }
		
		 public static void main(String[] args) {
		     // Create different account types (INHERITANCE)
		     Account a1 = new SavingsAccount("Ali", 1000.00, 0.06);      // 6% p.a.
		     Account a2 = new CheckingAccount("Siti", 500.00, 10.00);    // RM10 monthly fee
		
		     // ENCAPSULATION in action (we use methods, not direct field access)
		     a1.deposit(250.00);
		     a1.withdraw(100.00);
		
		     // Overloaded method (POLYMORPHISM: overloading)
		     a2.deposit(200.00, "Salary top-up");
		     a2.withdraw(50.00);
		
		     // Apply monthly actions (ABSTRACTION + POLYMORPHISM via overrides)
		     a1.applyMonthlyCharge(); // Savings: no fee
		     a2.applyMonthlyCharge(); // Checking: RM10 fee
		
		     // If an account is InterestBearing, apply interest (ABSTRACTION via interface)
		     if (a1 instanceof InterestBearing ib) {
		         double interest = ib.calculateMonthlyInterest();
		         // credit interest using encapsulated behavior
		         // We can't directly set balance (it's private),
		         // so we use a protected pathway via a tiny trick:
		         // deposit is public and validated.
		         a1.deposit(interest, "Monthly interest");
		     }
		
		     // POLYMORPHIC summaries
		     printAccountSummary(a1); // SavingsAccount summary
		     printAccountSummary(a2); // CheckingAccount summary
	 }
}
