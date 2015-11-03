package ELMS.vo;



public class BankAccountVO {
	String account;
	double amount;
	String bankName;
	public BankAccountVO(String accountID, double amount, String bankName) {
		this.account = accountID;
		this.amount = amount;
		this.bankName = bankName;
	}
	public String getAccount() {
		return account;
	}
	
	public void setAccount(String name){
		this.account = name;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount){
		this.amount = amount;
	}
	
	public String getBankName() {
		return bankName;
	}
	
	public void setBankName(String bankName){
		this.bankName = bankName;
	}
}
