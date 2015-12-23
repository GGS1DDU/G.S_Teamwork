package elms.businesslogic.financebl;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;

import elms.businesslogic_service.financeblservice.ExpenseBlService;
import elms.dataservice.DataFactory;
import elms.dataservice.dealdataservice.DealDataService;
import elms.dataservice.financedataservice.BankAccountDataService;
import elms.dataservice.financedataservice.ExpenseDataService;
import elms.dataservice.financedataservice.FreightStrategyDataService;
import elms.dataservice.financedataservice.IncomeDataService;
import elms.dataservice.financedataservice.InitAllDataService;
import elms.dataservice.logdataservice.LogDataService;
import elms.dataservice.storagedataservice.StorageDataService;
import elms.dataservice.userdataservice.UserDataService;
import elms.po.FExpensePO;
import elms.vo.FExpenseVO;

//写一个专门的resultmessage类，用于存储返回类型
//add  id已存在，返回id重复，      
//在bankAccountManager里的changeBalance方法中，若找不到对应银行账户
//  或该账户不能支出

public class ExpenseManager implements ExpenseBlService,DataFactory{
	
	ExpenseDataService expensedata;
	BankAccountManager bankAccount;
	
	
	
	public static void main(String args[]) throws RemoteException{
		ExpenseManager em = new ExpenseManager();
		FExpenseVO vo = new FExpenseVO("ba00000003","ex00000003","人员工资","2015-11-27",200.0,
				"记录人","支出人");
		boolean addSuccess = em.addExpense(vo);
//		boolean success = em.deleteExpense(vo);
//		System.out.println(success);
	}
	
	public ExpenseManager() throws RemoteException{
		expensedata = getExpenseData();
	}
	
	private FExpenseVO POtoVO(FExpensePO po){
		FExpenseVO vo = new FExpenseVO(po.getBankAccountName(),po.getID(),po.getCategory(),po.getTime(),
				po.getExpense(),po.getAssistant(),po.getClerk());
		return vo;
	}
	
	private FExpensePO VOtoPO(FExpenseVO vo){
		FExpensePO po = new FExpensePO(vo.getBankAccountName(),vo.getID(),vo.getCategory(),vo.getTime(),
				vo.getExpense(),vo.getAssistant(),vo.getClerk());
		return po;
	}
	
	public FExpenseVO inquiryExpense(String id) {
		// TODO 自动生成的方法存根
		try {
			FExpensePO po = expensedata.find(id);
			if(po==null)
				return null;
			FExpenseVO vo = POtoVO(po);
			return vo;
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return null;
		} 
		
	}
	
	public ArrayList<FExpenseVO> inquiryByTime(String time1,String time2){
		try {
			ArrayList<FExpensePO> arr = expensedata.findByTime(time1, time2);
			ArrayList<FExpenseVO> result = new ArrayList<FExpenseVO>();
			for(int i = 0; i < arr.size(); i++){
				FExpensePO po = arr.get(i);
				FExpenseVO vo = POtoVO(po);
				result.add(vo);
			}
			return result;
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return null;
		} 
		
		
	}

	public boolean addExpense(FExpenseVO vo) {
		// TODO 自动生成的方法存根
		
		if(inquiryExpense(vo.getID())!=null){
			return false;
		}
		
		FExpensePO po = VOtoPO(vo);
		try {
			expensedata.insert(po);
			bankAccount = new BankAccountManager();
			boolean changeSuccess = bankAccount.changeBalance(vo.getBankAccountName(), "expense", vo.getExpense());
			if(!changeSuccess)
				return false;
			return true;
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return false;
		} 
		
	}

	public boolean deleteExpense(FExpenseVO vo) {
		// TODO 自动生成的方法存根
		FExpensePO po = VOtoPO(vo);
		try {
			expensedata.delete(po);
			return true;
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return false;
		}
		
	}

	public FExpenseVO changeExpense(FExpenseVO vo) {
		// TODO 自动生成的方法存根
		
		FExpensePO po = VOtoPO(vo);
		
		try {
			expensedata.update(po);
			return vo;
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return null;
		}
		
	}

	

	public UserDataService getUserData() {
		// TODO 自动生成的方法存根
		return null;
	}

	public DealDataService getDealData() {
		// TODO 自动生成的方法存根
		return null;
	}

	public IncomeDataService getIncomeData() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public ExpenseDataService getExpenseData() throws RemoteException {
		// TODO 自动生成的方法存根
		DataFactory df;
		try{
			df = (DataFactory)Naming.lookup("rmi://localhost:1099/df");
			return df.getExpenseData();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
	}

	public BankAccountDataService getBankAccountData() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public FreightStrategyDataService getFreightStrategyData()
			throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public InitAllDataService getInitData() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public LogDataService getLogData() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public StorageDataService getStorageData() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}


	
}