package ELMS.businesslogic.FinanceBL;

import java.util.ArrayList;

import ELMS.businesslogicService.FinanceBlService;
import ELMS.po.FExpensePO;
import ELMS.vo.BankAccountVO;
import ELMS.vo.FExpenseVO;
import ELMS.vo.FIncomeVO;
import ELMS.vo.FreightStrategyVO;

public class FinanceController implements FinanceBlService{

	
	
	FinanceInAndEx inAndEx = new FinanceInAndEx();
	FinanceBankAccount bankAccount = new FinanceBankAccount();
	FinanceFreight freight = new FinanceFreight();
	FinanceInitAll initAll = new FinanceInitAll();
	
	
	public FIncomeVO inquiryIncome(String id) {
		// TODO 自动生成的方法存根
		FIncomeVO in = inAndEx.inquiryIncome(id);
		return in;
	}

	public FExpenseVO inquiryExpense(String id) {
		// TODO 自动生成的方法存根
		FExpenseVO ex = inAndEx.inquiryExpense(id);
		return ex;
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

	public FExpenseVO changeExpense(FExpenseVO vo) {
		// TODO 自动生成的方法存根
		return null;
	}

	public boolean createForm(String time1, String time2) {
		// TODO 自动生成的方法存根
		return false;
	}

	public boolean deriveForm(String operator) {
		// TODO 自动生成的方法存根
		return false;
	}

	public boolean initAll(String operator) {
		// TODO 自动生成的方法存根
		return false;
	}

	public boolean initFreight() {
		// TODO 自动生成的方法存根
		return false;
	}

	public FreightStrategyVO setFreight(FreightStrategyVO vo) {
		// TODO 自动生成的方法存根
		return null;
	}

	public boolean addAccount(BankAccountVO vo) {
		// TODO 自动生成的方法存根
		return false;
	}

	public boolean deleteAccount(String bankAccount) {
		// TODO 自动生成的方法存根
		return false;
	}

	public BankAccountVO changeAccount(String accountName) {
		// TODO 自动生成的方法存根
		return null;
	}

	public BankAccountVO inquiryAccount(String accountName) {
		// TODO 自动生成的方法存根
		return null;
	}

	public ArrayList<BankAccountVO> inquiryAccountByBank(String BankName) {
		// TODO 自动生成的方法存根
		return null;
	}

	public void endFinanceOpt() {
		// TODO 自动生成的方法存根
		
	}

}
