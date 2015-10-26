package ELMS.businesslogic.FinanceBL;

import java.util.ArrayList;





import ELMS.businesslogicService.FinanceBlFormService;
import ELMS.vo.FExpenseVO;
import ELMS.vo.FIncomeVO;


public class Form_Stub implements FinanceBlFormService{

	

	public boolean deriveForm(String operator) {
		// TODO �Զ����ɵķ������
		return true;
	}

	public boolean endFormOpt() {
		// TODO �Զ����ɵķ������
		return true;
	}

	public ArrayList<FIncomeVO> createInForm(String time1, String time2) {
		// TODO �Զ����ɵķ������
		ArrayList<FIncomeVO> income = new ArrayList<FIncomeVO>();
		
		income.add(new FIncomeVO("in000001","20150101",1000.0,"0251000","郑闻昊"));
		income.add(new FIncomeVO("in000002","20150103",100.0,"0251000","郑闻昊"));
		income.add(new FIncomeVO("in000003","20150201",1000.0,"0251001","周颖婷"));
		
		return income;
	}

	public ArrayList<FExpenseVO> createExForm(String time1, String time2) {
		// TODO �Զ����ɵķ������
		ArrayList<FExpenseVO> expense = new ArrayList<FExpenseVO>();
		
		expense.add(new FExpenseVO("ex000001","发工资","20150101",1000.0,"郑闻昊","张文玘"));
		expense.add(new FExpenseVO("ex000002","运费记录","20150101",100.0,"周颖婷","张文玘"));
		expense.add(new FExpenseVO("ex000003","固定成本","20150101",100.0,"张海涛","张文玘"));
		
		return expense;
	}

	public double getTotalIncome(ArrayList<FIncomeVO> in) {
		// TODO �Զ����ɵķ������
		
		return 19400.20;
	}

	public double getTotalExpense(ArrayList<FExpenseVO> ex) {
		// TODO �Զ����ɵķ������
		return 13400.01;
	}

	public double getBalance(double totalIncome, double totalExpense) {
		// TODO �Զ����ɵķ������
		return 6000.19;
	}

	public boolean init(String operator) {
		// TODO 自动生成的方法存根
		return false;
	}

}
