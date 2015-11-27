package elms.businesslogic_service.financeblservice;

import java.util.ArrayList;

import elms.po.FExpensePO;
import elms.vo.FExpenseVO;



public interface ExpenseBlService {
	public FExpenseVO inquiryExpense(String id);
	
	public boolean addExpense(FExpenseVO vo);
	
	public boolean deleteExpense(FExpenseVO vo);
	
	public FExpenseVO changeExpense(FExpenseVO vo);
	
	public ArrayList<FExpenseVO> inquiryByTime(String time1,String time2);
}
