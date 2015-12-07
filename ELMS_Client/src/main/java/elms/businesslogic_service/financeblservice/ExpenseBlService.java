package elms.businesslogic_service.financeblservice;

import java.util.ArrayList;



import elms.businesslogic.ResultMessage;
import elms.po.FExpensePO;
import elms.vo.FExpenseVO;



public interface ExpenseBlService {
	public FExpenseVO inquiryExpense(String id);
	
	public ResultMessage addExpense(FExpenseVO vo);
	
	public ResultMessage deleteExpense(FExpenseVO vo);
	
	public ResultMessage changeExpense(FExpenseVO vo);
	
	public ArrayList<FExpenseVO> inquiryByTime(String time1,String time2);
	
	public ArrayList<FExpenseVO> inquiryAll();
}
