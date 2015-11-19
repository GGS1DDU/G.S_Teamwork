package ELMS.businesslogic.FinanceBL;


import java.rmi.RemoteException;
import java.util.ArrayList;

import ELMS.businesslogicService.FinanceBlService;
import ELMS.po.BankAccountPO;
import ELMS.po.FExpensePO;
import ELMS.po.FreightStrategyPO;
import ELMS.vo.BankAccountVO;
import ELMS.vo.FExpenseVO;
import ELMS.vo.FIncomeVO;
import ELMS.vo.FreightStrategyVO;

public class FinanceController implements FinanceBlService{

	
	

	FinanceIncome income = new FinanceIncome();
	FinanceExpense expense = new FinanceExpense();
	FinanceStatistic statistic = new FinanceStatistic();
	FinanceBankAccount bankAccount = new FinanceBankAccount();
	FinanceFreight freight = new FinanceFreight();
	FinanceInitAll initAll = new FinanceInitAll();
	
	

	public boolean addIncome(FIncomeVO vo) {
		// TODO 自动生成的方法存根
		if(income.addIncome(vo))
			return true;
		return false;
	}
	
	public FIncomeVO inquiryIncome(String id) {
		// TODO 自动生成的方法存�?
		FIncomeVO in = income.inquiryIncome(id);
		return in;
	}

	public FExpenseVO inquiryExpense(String id) {
		// TODO 自动生成的方法存�?
		FExpenseVO ex = expense.inquiryExpense(id);
		return ex;
	}

	public ArrayList<FIncomeVO> inquiryIncomeByHall(String center) {
		// TODO 自动生成的方法存�?
		
		return income.inquiryIncomeByHall(center);
	}

	public ArrayList<FIncomeVO> inquiryIncomeByTime(String time1, String time2) throws RemoteException {
		// TODO 自动生成的方法存�?
		return income.inquiryIncomeByTime(time1, time2);
	}

	public ArrayList<FIncomeVO> inquiryInByTimeHall(String time1, String time2,
			String center) {
		// TODO 自动生成的方法存�?
		return income.inquiryInByTimeHall(time1, time2, center);
	}

	public ArrayList<FExpenseVO> inquiryExpenseByTime(String time1, String time2) {
		// TODO 自动生成的方法存�?
		return expense.inquiryExpenseByTime(time1, time2);
	}

	public boolean addExpense(FExpenseVO vo) {
		// TODO 自动生成的方法存�?
		if(expense.addExpense(vo))
			return true;
		return false;
	}

	public boolean deleteExpense(FExpensePO po) {
		// TODO 自动生成的方法存�?
		if(expense.deleteExpense(po))
			return true;
		return false;
	}

	public FExpenseVO changeExpense(FExpenseVO vo) {
		// TODO 自动生成的方法存�?
		return expense.changeExpense(vo.getID());
	}

	public boolean createForm(String time1, String time2) throws RemoteException {
		// TODO 自动生成的方法存�?
		if(statistic.createForm(time1, time2))
			return true;
		return false;
	}

	public boolean deriveForm(String operator) {
		// TODO 自动生成的方法存�?
		if(statistic.deriveForm(operator))
			return true;
		return false;
	}

	public boolean initAll(String operator) {
		// TODO 自动生成的方法存�?
		if(initAll.initAll(operator))
			return true;
		return false;
	}

	public boolean initFreight() {
		// TODO 自动生成的方法存�?
		if(freight.initFreight())
			return true;
		return false;
	}

	public FreightStrategyPO getFreightStrategy(){
		return freight.getFreightStrategy();
	}
	
	public FreightStrategyVO setFreight(FreightStrategyVO vo) {
		// TODO 自动生成的方法存�?
		return freight.setFreight(vo);
	}

	public boolean addAccount(BankAccountVO vo) {
		// TODO 自动生成的方法存�?
		if(bankAccount.addAccount(vo))
			return true;
		return false;
	}

	public boolean deleteAccount(String bankAccountName) {
		// TODO 自动生成的方法存�?
		if(bankAccount.deleteAccount(bankAccountName))
			return true;
		return false;
	}

	public BankAccountVO changeAccount(String accountID,String accountName) {
		// TODO 自动生成的方法存�?
		return bankAccount.changeAccount(accountID,accountName);
	}

	public BankAccountVO inquiryAccount(String accountName) {
		// TODO 自动生成的方法存�?
		return bankAccount.inquiryAccount(accountName);
	}

	public ArrayList<BankAccountVO> inquiryAccountByBank(String BankName) {
		// TODO 自动生成的方法存�?
		try {
			return bankAccount.inquiryAccountByBank(BankName);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			
			e.printStackTrace();
			return null;
		}
		
	}
	
	public ArrayList<BankAccountPO> getAllAccount() {
		// TODO 自动生成的方法存根
		return bankAccount.getAllAccount();
	}

	public void endFinanceOpt() {
		// TODO 自动生成的方法存�?
		
	}


	

}
