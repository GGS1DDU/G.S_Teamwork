package elms.businesslogic_service.financeblservice;

import elms.po.FExpensePO;
import elms.vo.FExpenseVO;



public interface ExpenseBlService {
	public FExpenseVO inquiryExpense(String id);
	
	public boolean addExpense(FExpenseVO vo);
	
	public boolean deleteExpense(FExpensePO po);
	
	public FExpenseVO changeExpense(FExpenseVO vo);
}
