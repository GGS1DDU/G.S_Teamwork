package ELMS.businesslogic.FinanceBL;

import java.util.ArrayList;

import ELMS.po.FExpensePO;
import ELMS.vo.FExpenseVO;
import ELMS.vo.FIncomeVO;

public class FinanceInAndEx{
	
	public FIncomeVO inquiryIncome(String id) {
		// TODO 自动生成的方法存根
		System.out.println("inquiry");
		return null;
	}

	public FExpenseVO inquiryExpense(String id) {
		// TODO 自动生成的方法存根
		return null;
	}

	public ArrayList<FIncomeVO> inquiryIncomeByHall(String center) {
		// TODO 自动生成的方法存根
		return null;
	}

	public ArrayList<FIncomeVO> inquiryIncomeByTime(String time1, String time2) {
		// TODO 自动生成的方法存根
		return null;
	}

	public ArrayList<FIncomeVO> inquiryInByTimeHall(String time1, String time2,
			String center) {
		// TODO 自动生成的方法存根
		return null;
	}

	public ArrayList<FExpenseVO> inquiryExpenseByTime(String time1, String time2) {
		// TODO 自动生成的方法存根
		return null;
	}

	public boolean addExpense(FExpenseVO vo) {
		// TODO 自动生成的方法存根
		return false;
	}

	public boolean deleteExpense(FExpensePO po) {
		// TODO 自动生成的方法存根
		return false;
	}

	public FExpenseVO changeExpense(String expenseID) {
		// TODO 自动生成的方法存根
		return null;
	}

	public boolean createForm(String time1, String time2) {
		// TODO 自动生成的方法存根
		ArrayList<FIncomeVO> incomeList = this.inquiryIncomeByTime(time1, time2);
		ArrayList<FExpenseVO> expenseList = this.inquiryExpenseByTime(time1, time2);
		double totalIn = this.getTotalIn(incomeList);
		double totalEx = this.getTotalEx(expenseList);
		double profit = totalIn-totalEx;
		return false;
	}
	
	public double getTotalIn(ArrayList<FIncomeVO> vo){
		return 0;
	}
	
	public double getTotalEx(ArrayList<FExpenseVO> vo){
		return 0;
	}

	public boolean deriveForm(String operator) {
		// TODO 自动生成的方法存根
		return false;
	}
	
	public void endFinanceOpt() {
		// TODO 自动生成的方法存根
		
	}


}
