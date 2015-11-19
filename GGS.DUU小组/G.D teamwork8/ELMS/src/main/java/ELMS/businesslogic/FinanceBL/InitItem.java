package ELMS.businesslogic.FinanceBL;

import java.util.ArrayList;


import ELMS.po.BankAccountPO;
import ELMS.vo.BankAccountVO;

public class InitItem {
	
	
	
	FinanceBankAccount bankAccount = new FinanceBankAccount();
//	public ArrayList<BankAccountPO> getAllAccount(){
//		return bankAccount.getAllAccount();
//	}
	
	public void deleteAccount(String AccountName){
		bankAccount.deleteAccount(AccountName);
	}
	
//	public ArrayList<CarPO> getCarInfo(){
//		 
//		return null;
//	}
}
