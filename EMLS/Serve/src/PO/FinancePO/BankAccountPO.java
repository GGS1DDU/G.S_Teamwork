package FinancePO;

public class BankAccountPO {
String account;
double amount;
String bankName;
public BankAccountPO(String account, double amount, String bankName) {
	this.account = account;
	this.amount = amount;
	this.bankName = bankName;
}
public String getAccount() {
	return account;
}
public double getAmount() {
	return amount;
}
public String getBankName() {
	return bankName;
}
}
