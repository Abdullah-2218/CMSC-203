
public class CheckingAccount extends BankAccount {
	
	//constant fee of 15 cents
	private static final double FEE = 0.15;
	
	//constructor
	public CheckingAccount(String name, double amount)
	{
		super(name, amount);
		
		//modify account number by adding -10
		setAccountNumber(getAccountNumber() + "-10");
	}

	// override withdraw method
	@Override
	public boolean withdraw(double amount)
	{
		//add fee to withdrawal
		return super.withdraw(amount + FEE);
	}
}
