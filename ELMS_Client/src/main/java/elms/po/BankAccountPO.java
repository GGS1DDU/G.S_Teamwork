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
	
	public BankAccountPO() {
		// TODO 自动生成的构造函数存根
	}

	public String getID(){
		return accountID;
	}
	
	public void setID(String accountID){
		this.accountID = accountID;
	}
	
	public String getName(){
		return account;
	}
	
	public void setName(String accountName){
		this.account = accountName;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount){
		this.amount = amount;
	}
	           
	
	public String getBank() {
		return bankName;
	}
	
	public void setBank(String bankName){
		this.bankName = bankName;
	}
}
