package lab4;

public class CurrentAccount extends Account {

	public CurrentAccount(String arg1, double arg2) {
		super(arg1,arg2);
		this.otherAccount = null;
	}
	
	public CurrentAccount(String arg1, double arg2, double arg3) {
		super(arg1,arg2,arg3);
	}
		
	public void savings (double arg) {
		
		if (this.getSavingsAccount()!=null) {
			double currentMoney = getBalance();
			double savingsMoney = otherAccount.getBalance();
			
			if (arg>0) {
				if (currentMoney - arg> 0) {
					setBalance(getBalance()-arg);
					otherAccount.setBalance(otherAccount.getBalance()+arg);
					otherAccount.transactions.add("To savings account: " + arg);
					transactions.add("From current account: "+ arg);
				}
				else {
					arg = currentMoney;
					setBalance(getBalance()-arg);
					otherAccount.setBalance(otherAccount.getBalance()+arg);
					otherAccount.transactions.add("To savings account: " + arg);
					transactions.add("From current account: "+ arg);
				}
			} 
			if (arg<=0) {
				arg *= -1;
				if(savingsMoney - arg > 0) {
					otherAccount.setBalance(otherAccount.getBalance()-arg);
					setBalance(getBalance()+arg);
					transactions.add("To current account: " + arg);
					otherAccount.transactions.add("From savings account: "+ arg);
				}
				else {
					arg = savingsMoney;
					otherAccount.setBalance(otherAccount.getBalance()-arg);
					setBalance(getBalance()+arg);
					transactions.add("To current account: " + arg);
					otherAccount.transactions.add("From savings account: "+ arg);
				}
			}
			
			
		}
		else {
			return;
		}
		
	}
	
}




