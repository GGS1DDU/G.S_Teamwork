package elms.po;

import java.io.Serializable;

//

public class BankAccountPO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String accountID;
	String account;
	double amount;
	String bankName;
	
	
	
	public BankAccountPO(String accountID,String accountName, double amount, String bankName) {
		this.accountID = accountID;
		this.account = accountName;
		this.amount = amount;
		this.bankName = bankName;
	}
	
	public String getAccountID(){
		return accountID;
	}
	
	public void setAccountID(String accountID){
		this.accountID = accountID;
	}
	
	public String getAccountName(){
		return account;
	}
	
	public void setAccountName(String accountName){
		this.account = accountName;
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
