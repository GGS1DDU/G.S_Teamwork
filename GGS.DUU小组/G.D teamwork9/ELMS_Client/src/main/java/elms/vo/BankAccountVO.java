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
	public BankAccountVO() {
		// TODO 自动生成的构造函数存根
	}
	public String getID() {
		return accountID;
	}
	
	public void setID(String id){
		this.accountID = id;
	}
	
	public String getName() {
		return account;
	}
	
	public void setName(String name){
		this.account = name;
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
