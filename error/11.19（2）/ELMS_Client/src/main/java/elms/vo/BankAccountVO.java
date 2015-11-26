package elms.vo;



public class BankAccountVO {
	String accountID;
	String account;
	double amount;
	String bankName;
	public BankAccountVO(String accountID,String accountName, double amount, String bankName) {
		this.accountID = accountID;
		this.account = accountName;
		this.amount = amount;
		this.bankName = bankName;
	}
	public String getAccountID() {
		return accountID;
	}
	
	public void setAccountID(String id){
		this.accountID = id;
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
