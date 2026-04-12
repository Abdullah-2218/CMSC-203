
public class SavingsAccount extends BankAccount{

	private static final double RATE = 0.025; // 2.5% annual interest
	private int savingsNumber = 0;
	
	// hides superclass accountNumber
	private String accountNumber;
	
	//constructor
	public SavingsAccount(String name, double amount)
	{
		super (name, amount);
		accountNumber = super.getAccountNumber() + "-" + savingsNumber;
		
	}
	
	//copy constructor
	public SavingsAccount(SavingsAccount oldAccount, double amount)
	{
		super(oldAccount, amount);
		
		this.savingsNumber = oldAccount.savingsNumber + 1;
		this.accountNumber = super.getAccountNumber() + "-" + savingsNumber;
	
	}
	
	// post monthly interest
	public void postInterest()
	{
		double monthlyInterest = getBalance() * (RATE / 12);
		deposit(monthlyInterest);
		
	}
	
	@Override
	public String getAccountNumber()
	{
		return accountNumber;
	}
}
