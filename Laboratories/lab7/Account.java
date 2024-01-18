public class Account {
	private double balance; 
	NotEnoughMoneyException nem; 
	
	public Account() {
		balance=0; 
	}

	public void deposit(double amount){
		balance=balance+amount; 
		System.out.println("new balance="+balance+"$"); 
	}

	public void withdraw(double amount)throws NotEnoughMoneyException{

		if(amount<=balance) {
			balance=balance-amount; 
			System.out.println("new balance="+balance+"$"); 
		}

		else {
			nem=new NotEnoughMoneyException("you have not enough money to withdraw "+amount+"$", amount, balance);
			throw nem;
		}
	}
}

