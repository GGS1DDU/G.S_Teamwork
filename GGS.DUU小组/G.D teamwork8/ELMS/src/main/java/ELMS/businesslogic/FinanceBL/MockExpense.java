package ELMS.businesslogic.FinanceBL;

public class MockExpense extends FinanceExpense{
	double expense;
	String bankAccountName;
	
	public MockExpense(double amount,String bankAccountName){
		this(amount);
		this.bankAccountName = bankAccountName;
	}
	
	public MockExpense(double amount){
		expense  = amount;
	}
	
	public String getAccountName(){
		return bankAccountName;
	}
	
	public double getExpense(){
		return this.expense;
	}
}
