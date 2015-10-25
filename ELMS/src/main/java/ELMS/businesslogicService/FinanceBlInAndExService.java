package ELMS.businesslogicService;

import java.util.ArrayList;

import ELMS.vo.FExpenseVO;
import ELMS.vo.FIncomeVO;


public interface FinanceBlInAndExService {
	
	public FIncomeVO inquiryIncome(String id);
	
	public FExpenseVO inquiryExpense(String id);
	
	public ArrayList<FIncomeVO> inquiryIncomeByHall(String center);
	
	public ArrayList<FIncomeVO> inquiryIncomeByTime(String time1, String time2);
	
	public ArrayList<FIncomeVO> inquiryInByTimeHall(String time1, String time2, String center);
	
	public ArrayList<FExpenseVO> inquiryExpenseByTime(String time1, String time2);
	
	public void endInAndExOpt();
}
