package ELMS.businesslogic.FinanceBL;

import java.rmi.RemoteException;
import java.util.ArrayList;

import ELMS.data.FinanceData.FinanceData;
import ELMS.po.FIncomePO;

import ELMS.vo.FIncomeVO;

public class FinanceIncome {

	ArrayList<FIncomeVO> inList = new ArrayList<FIncomeVO>();
	FinanceBankAccount fba = new FinanceBankAccount();
	

	public boolean addIncome(FIncomeVO vo){
//			fd.insertIncome(po);
					inList.add(vo);
		//			fba = FinanceBankAccount.bavo;
					fba.changeBalance(vo.getBankAccountName(), "income", vo.getIncome());
					return true;
		
	}
	
	public FIncomeVO inquiryIncome(String id) {
		// TODO 自动生成的方法存�?
		System.out.println("inquiry");
		return null;
	}

	

	public ArrayList<FIncomeVO> inquiryIncomeByHall(String center) {
		// TODO 自动生成的方法存�?
		return null;
	}

	public ArrayList<FIncomeVO> inquiryIncomeByTime(String time1, String time2) throws RemoteException {
		// TODO 自动生成的方法存�?
		FinanceData fd = new FinanceData();
		ArrayList<FIncomePO> incomeData = fd.findIncome(time1, time2);
		ArrayList<FIncomeVO> incomePresen = new ArrayList<FIncomeVO>();
		
		for(int i = 0; i < incomeData.size(); i++){
			FIncomePO po = incomeData.get(i);
			String id = po.getID();
			String clerk = po.getClerk();
			double income = po.getIncome();
			String time = po.getTime();
			String hall = po.getShop();
			FIncomeVO vo = new FIncomeVO(id,time,income,hall,clerk);
			incomePresen.add(vo);
		}
		
		return incomePresen;
	}

	public ArrayList<FIncomeVO> inquiryInByTimeHall(String time1, String time2,
			String center) {
		// TODO 自动生成的方法存�?
		return null;
	}

	
	
	
}
