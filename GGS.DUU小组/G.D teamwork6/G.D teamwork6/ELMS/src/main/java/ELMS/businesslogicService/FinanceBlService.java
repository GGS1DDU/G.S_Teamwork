package ELMS.businesslogicService;

import java.util.ArrayList;

import ELMS.po.FExpensePO;
import ELMS.vo.BankAccountVO;
import ELMS.vo.FExpenseVO;
import ELMS.vo.FIncomeVO;
import ELMS.vo.FreightStrategyVO;


public interface FinanceBlService {
	
	public FIncomeVO inquiryIncome(String id);
	
	public FExpenseVO inquiryExpense(String id);
	
	public ArrayList<FIncomeVO> inquiryIncomeByHall(String center);
	
	public ArrayList<FIncomeVO> inquiryIncomeByTime(String time1, String time2);
	
	public ArrayList<FIncomeVO> inquiryInByTimeHall(String time1, String time2, String center);
	
	public ArrayList<FExpenseVO> inquiryExpenseByTime(String time1, String time2);
	
	public boolean addExpense(FExpenseVO vo);
	
	public boolean deleteExpense(FExpensePO po);
	
	public FExpenseVO changeExpense(String expenseID);
	
	
	
//	public double getTotalIncome(ArrayList<FIncomeVO> in);
//	
//	public double getTotalExpense(ArrayList<FExpenseVO> ex);
//	
//	public double getBalance(double totalIncome, double totalExpense);
	
	public boolean deriveForm(String operator);
	
	
	
	public boolean initAll(String operator);//期初建账
	
	
	
	public boolean initFreight();
	
	public FreightStrategyVO update(FreightStrategyVO vo);
	
	
	
	public boolean addAccount(BankAccountVO vo);
	
	public boolean deleteAccount(String bankAccount);
	
	public BankAccountVO changeAccount(String accountName);
	
	public BankAccountVO inquiryAccount(String accountName);
	
	public ArrayList<BankAccountVO> inquiryAccountByBank(String BankName);
	
	
	
	public void endFinanceOpt();
	
}
