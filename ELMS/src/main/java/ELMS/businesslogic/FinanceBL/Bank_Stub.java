package ELMS.businesslogic.FinanceBL;

import java.util.ArrayList;

import ELMS.businesslogicService.FinanceBlBankService;
import ELMS.po.BankAccountPO;
import ELMS.vo.BankAccountVO;


public class Bank_Stub implements FinanceBlBankService{
	public boolean addAccount(BankAccountVO vo) {
		// TODO 自动生成的方法存根
		return true;
	}

	public boolean deleteAccount(String bankAccout) {
		// TODO 自动生成的方法存根
		return true;
	}

	public BankAccountVO changeAccount(String accountName) {
		// TODO 自动生成的方法存根
		return new BankAccountVO(accountName,0,"中国工商银行");
	}

	public BankAccountVO inquiryAccount(String accountName) {
		// TODO 自动生成的方法存根
		return new BankAccountVO(accountName,100,"中国银行");
	}

	public ArrayList<BankAccountVO> inquiryAccountByBank(String BankName) {
		// TODO 自动生成的方法存根
		ArrayList<BankAccountVO> bankAccount = new ArrayList<BankAccountVO>();
		
		bankAccount.add(new BankAccountVO("00000001",0,BankName));
		bankAccount.add(new BankAccountVO("00000002",100,BankName));
		bankAccount.add(new BankAccountVO("00000003",10000,BankName));
		bankAccount.add(new BankAccountVO("00000004",1000,BankName));
		
		return bankAccount;
	}

	public void endBankOpt() {
		// TODO 自动生成的方法存根
		
	}

}
