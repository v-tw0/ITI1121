public class NotEnoughMoneyException extends IllegalStateException{

private double amount; 
private double balance; 

	public NotEnoughMoneyException(String s,double amount,double balance) {
		super(s); 
		this.amount=amount;
		this.balance=balance;
	}

	public double getBalance(){
		return balance;
	}

	public double getAmount(){
		return amount;
	}

	public double getMissingAmount(){
		return amount-balance;
	}
}