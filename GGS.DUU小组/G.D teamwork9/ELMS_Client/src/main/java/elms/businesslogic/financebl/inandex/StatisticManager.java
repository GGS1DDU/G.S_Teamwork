package elms.businesslogic.financebl.inandex;

import java.rmi.RemoteException;
import java.util.ArrayList;


import elms.vo.FExpenseVO;
import elms.vo.FIncomeVO;


//这个类负责对总收入总支出以及报表的相关操作
public class StatisticManager {
	
	ExpenseManager exmanage;
	IncomeManager inmanage;
	double profit;
	ArrayList<FIncomeVO> incomeList;
	ArrayList<FExpenseVO> expenseList;
	
	public StatisticManager(){
		exmanage = new ExpenseManager();
		inmanage = new IncomeManager();
		profit = 0.0;
	}
	
	public ArrayList<FIncomeVO> getIncome(String time1,String time2){
		try {
			ArrayList<FIncomeVO> income = inmanage.inquiryIncomeByTime(time1, time2);
			return income;
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<FExpenseVO> getExpense(String time1,String time2){
		ArrayList<FExpenseVO> expense = exmanage.inquiryByTime(time1, time2);
		return expense;
	}
	
	public double getTotalIn(ArrayList<FIncomeVO> in){
		double result = 0.0;
		if(in==null){
			return result;
		}
		for(FIncomeVO vo:in){
			result = result+vo.getIncome();
		}
		return result;
	}
	
	public double getTotalEx(ArrayList<FExpenseVO> ex){
		double result = 0.0;
		if(ex==null){
			return result;
		}
		for(FExpenseVO vo:ex){
			result += vo.getExpense();
		}
		return result;
	}
	
	public double getProfit(double in, double ex){
		return in-ex;
	}
	
	public boolean createForm(String time1, String time2){
		
		incomeList = getIncome(time1,time2);
		expenseList = getExpense(time1,time2);
		
		double totalIn = getTotalIn(incomeList); 
		double totalEx = getTotalEx(expenseList);
		profit = totalIn-totalEx;
		
		return true;
		
	}
	
	//将报表导出为excel表格，之后再写
	public boolean deriveForm(String operator){
		
		return false;
	}
}
