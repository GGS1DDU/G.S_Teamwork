package ELMS.businesslogic.FinanceBL;

public class MockIncome extends FinanceIncome{
	double income;
	String accountName;
	public MockIncome(double income){
		this.income = income;
	}
	
	public MockIncome(double income,String accountName){
		this(income);
		this.accountName = accountName;
	}
	
	public double getIncome(){
		return income;
	}
	
	public String getAccountName(){
		return accountName;
	}
}
