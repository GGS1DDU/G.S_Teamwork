package ELMS.businesslogic.FinanceBL;

import java.rmi.RemoteException;
import java.util.ArrayList;

import ELMS.vo.FExpenseVO;
import ELMS.vo.FIncomeVO;

public class FinanceStatistic {
	
	FinanceIncome income = new FinanceIncome();
	FinanceExpense expense = new FinanceExpense();
	
	public boolean createForm(String time1, String time2) throws RemoteException {
		// TODO 自动生成的方法存�?
		ArrayList<FIncomeVO> incomeList = income.inquiryIncomeByTime(time1, time2);
		ArrayList<FExpenseVO> expenseList = expense.inquiryExpenseByTime(time1, time2);
		double totalIn = this.getTotalIn(incomeList);
		double totalEx = this.getTotalEx(expenseList);
		double profit = totalIn-totalEx;
		return false;
	}
	
	public double getTotalIn(ArrayList<FIncomeVO> vo){
		double income = 0;
	
		for(int i = 0; i < vo.size(); i++){
			double partIncome = vo.get(i).getIncome();
			
			income = income + partIncome;
		}
		System.out.println(income);
		return income;
	}
	
	public double getTotalEx(ArrayList<FExpenseVO> vo){
		double expense = 0;
		
		for(int i = 0; i < vo.size(); i++){
			double partExpense = vo.get(i).getExpense();
			
			expense = expense+partExpense;
		}
		return expense;
	}

	public boolean deriveForm(String operator) {
		// TODO 自动生成的方法存�?
		return false;
	}
}
