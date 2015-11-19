package ELMS.businesslogic.FinanceBL;

import java.rmi.RemoteException;
import java.util.ArrayList;

import ELMS.data.FinanceData.FinanceData;
import ELMS.po.FExpensePO;
import ELMS.po.FIncomePO;
import ELMS.vo.FExpenseVO;

public class FinanceExpense {
	
	FinanceData fd = new FinanceData();
	FinanceBankAccount fba = new FinanceBankAccount();
	ArrayList<FExpenseVO> exList = new ArrayList<FExpenseVO>();
	
	public boolean addExpense(FExpenseVO vo) {
		// TODO 自动生成的方法存�?
		FExpensePO po = new FExpensePO(vo.getBankAccountName(),vo.getID(),vo.getCategory(),
				vo.getTime(),vo.getExpense(),vo.getAssistant(),vo.getClerk());
		try {
			fd.insertExpense(po);
			exList.add(vo);
//			fba = FinanceBankAccount.bavo;
			fba.changeBalance(vo.getBankAccountName(), "income", vo.getExpense());
			return true;
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean deleteExpense(FExpensePO po) {
		// TODO 自动生成的方法存�?
		return false;
	}

	public FExpenseVO changeExpense(String expenseID) {
		// TODO 自动生成的方法存�?
		return null;
	}
	
	public FExpenseVO inquiryExpense(String id) {
		// TODO 自动生成的方法存�?
		return null;
	}
	
	public ArrayList<FExpenseVO> inquiryExpenseByTime(String time1, String time2) {
		// TODO 自动生成的方法存�?
		return null;
	}
}
