package ELMS.businesslogicService;

import java.util.ArrayList;

import ELMS.vo.BankAccountVO;


public interface FinanceBlBankService {
	public boolean addAccount(BankAccountVO vo);
	
	public boolean deleteAccount(String bankAccount);
	
	public BankAccountVO changeAccount(String accountName);
	
	public BankAccountVO inquiryAccount(String accountName);
	
	public ArrayList<BankAccountVO> inquiryAccountByBank(String BankName);
	
	public void endBankOpt();
}
