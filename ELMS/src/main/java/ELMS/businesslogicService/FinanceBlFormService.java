package ELMS.businesslogicService;


import java.util.ArrayList;

import ELMS.vo.FExpenseVO;
import ELMS.vo.FIncomeVO;




public interface FinanceBlFormService {

	public boolean init(String operator);
	
	public ArrayList<FIncomeVO> createInForm(String time1, String time2);
	
	public ArrayList<FExpenseVO> createExForm(String time1, String time2);
	
	public double getTotalIncome(ArrayList<FIncomeVO> in);
	
	public double getTotalExpense(ArrayList<FExpenseVO> ex);
	
	public double getBalance(double totalIncome, double totalExpense);
	
	public boolean deriveForm(String operator);
	
	public boolean endFormOpt();
	
	
}
