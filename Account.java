package lab4;
import java.util.ArrayList;

public class Account {

	private static int accountNumbers = 1;
	private String customer;
	private int thisAccountNumber;
	private double balance;
	protected static Bank theBank;
	protected Account otherAccount;
	protected ArrayList<String> transactions;
	
	public Account(CurrentAccount arg) {
		
	}
	
	public Account(String arg1, double arg2) {
		customer = arg1;
		balance = arg2;
		thisAccountNumber = accountNumbers;
		accountNumbers +=1;
		transactions = new ArrayList<String>();
	}
	
	public Account(String arg1, double arg2, double arg3) {
		customer = arg1;
		balance = arg2;
		thisAccountNumber = accountNumbers;
		accountNumbers +=1;
		SavingsAccount savingsaccount = new SavingsAccount(arg1, arg3);
		otherAccount = savingsaccount;
		transactions = new ArrayList<String>();
	}
	
	public int getAccountNumber() {
		return thisAccountNumber;
	}
	
	public String getCustomer() {
		return customer;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double arg) {
		balance = arg;
	}
	
	public static void setBank(Bank arg) {
		theBank = arg;
	}
	
	public SavingsAccount getSavingsAccount() {
		
		 if (otherAccount != null && otherAccount instanceof SavingsAccount) {
		        return (SavingsAccount) otherAccount;
		    } else {
		        return null; 
	    }
	}

	
	public String toString() {
		
		String s = "";
		
		if (this instanceof CurrentAccount) {	
			s = "Current Account: "; 
		} else if (this instanceof SavingsAccount){
			s = "Savings Account: "; 
		}

		s = s + "with account number " + thisAccountNumber + ": " + balance +"\n";
		
		StringBuilder builder = new StringBuilder();
		
		for (int i = 0; i < transactions.size(); i++) {
			String addon = transactions.get(i) + "\n";
			builder.append(addon);
		}
		return s + builder;
	}
	
	
	
}








