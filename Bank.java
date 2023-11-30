package lab4;
import java.util.ArrayList;

public class Bank {

	public final String NAME;
	public ArrayList<Account> theAccounts;
	//you can initialize it when you declare it
	
	public Bank(String arg) {
		NAME = arg;
		Account.setBank(this); // copies its address to theBank in Account, no idea if this works
		theAccounts  = new ArrayList<Account>();
	}
	
	public CurrentAccount searchAccount(String arg) {
		
		for (int i = 0; i < this.theAccounts.size(); i++) {
			Account account = theAccounts.get(i);
			if (account.getCustomer().equals(arg) && account instanceof CurrentAccount) {
				return (CurrentAccount) account;
			}
		}
		return null;
	}
	
	public String createAccount(String arg1, double arg2, double arg3) {
		if(searchAccount(arg1)!=null){
			return "Account(s) already exists for " + arg1;
		}
		CurrentAccount newacc = new CurrentAccount(arg1, arg2, arg3);
		theAccounts.add(newacc);
		theAccounts.add(newacc.otherAccount);
		return "Current and savings account created for " + arg1;
	}
	
	public String createAccount(String arg1, double arg2) {
		if(searchAccount(arg1)!=null){
			return "Account(s) already exists for " + arg1;
		}
		CurrentAccount newacc = new CurrentAccount(arg1, arg2);
		theAccounts.add(newacc);
		return "Current account created for " + arg1;
	}
	
	public void currentToSavings(String arg1, double arg2) {
		if (searchAccount(arg1) != null) {
			searchAccount(arg1).savings(arg2);
		}
	}
	
	public String checkPerson(String arg) {
		
		CurrentAccount thisacc = searchAccount(arg);
		String s;
		
		if (thisacc==null) {
			return "Person does not exist\n";
		}
		else {

			s = thisacc.getCustomer() + "\n";
			s = s + thisacc.toString() + "\n";
			if (thisacc.getSavingsAccount()!= null) {
				s += thisacc.getSavingsAccount();
			}
		}
		
		return s;
	}
	
	public String toString() {
		String s = "BANK: " + NAME + "\n" + "Accounts: " + theAccounts.size();
		double currenttotal = 0;
		double savingstotal = 0;
		
		for (int i = 0; i < theAccounts.size(); i++) {
			currenttotal += theAccounts.get(i).getBalance();
			if (theAccounts.get(i).getSavingsAccount() != null) {
				savingstotal += theAccounts.get(i).getSavingsAccount().getBalance();
			}
		}
		
		s = s + "\n" + currenttotal + "\n" + savingstotal;
		return s;
	}
}








