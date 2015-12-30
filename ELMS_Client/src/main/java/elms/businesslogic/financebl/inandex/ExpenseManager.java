package elms.businesslogic.financebl.inandex;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;

import elms.businesslogic.ResultMessage;
import elms.businesslogic.financebl.BankAccountManager;
import elms.businesslogic_service.financeblservice.ExpenseBlService;
import elms.dataservice.DataFactory;
import elms.dataservice.dealdataservice.DealDataService;
import elms.dataservice.financedataservice.BankAccountDataService;
import elms.dataservice.financedataservice.ExpenseDataService;
import elms.dataservice.financedataservice.IncomeDataService;
import elms.dataservice.financedataservice.InitAllDataService;
import elms.dataservice.invoicedataservice.ArrivalListDataService;
import elms.dataservice.invoicedataservice.IncomeListDataService;
import elms.dataservice.invoicedataservice.LoadingListDataService;
import elms.dataservice.invoicedataservice.LoadingListZZDataService;
import elms.dataservice.invoicedataservice.RecivalListDataService;
import elms.dataservice.invoicedataservice.SendingListDataService;
import elms.dataservice.invoicedataservice.TransferListDataService;

import elms.dataservice.managerdataservice.FreightStrategyDataService;
import elms.dataservice.managerdataservice.StaffDataService;
import elms.dataservice.memberdataservice.CarDataService;
import elms.dataservice.memberdataservice.DriverDataService;
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
		FExpenseVO vo = new FExpenseVO("ba00000003","ex00000002","人员工资","2015-11-27",100.0,
				"记录人","支出人");
//		System.out.println(em.addExpense(vo));
//		boolean success = em.deleteExpense(vo);
		System.out.println(em.changeExpense(vo));
	}
	
	public ExpenseManager(){
		try {
			expensedata = getExpenseData();
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
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
	
	public ArrayList<FExpenseVO> inquiryAll(){
		try {
			ArrayList<FExpensePO> arr = expensedata.findAll();
			ArrayList<FExpenseVO> result = new ArrayList<FExpenseVO>();
			for(int i = 0; i < arr.size(); i++){
				FExpensePO po = arr.get(i);
				FExpenseVO vo = POtoVO(po);
				result.add(vo);
			}
			return result;
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	public ArrayList<FExpenseVO> inquiryByTime(String time1,String time2){
		try {
			ArrayList<FExpensePO> arr = expensedata.findByTime(time1, time2);
			ArrayList<FExpenseVO> result = new ArrayList<FExpenseVO>();
			if(arr==null){
				return null;
			}
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

	public ResultMessage addExpense(FExpenseVO vo) {
		// TODO 自动生成的方法存根
		
		if(inquiryExpense(vo.getID())!=null){
			return ResultMessage.findIDFailed;     //要求用户重新输入id
		}
		
		FExpensePO po = VOtoPO(vo);
		try {
			
			bankAccount = new BankAccountManager();
			ResultMessage rm = bankAccount.changeBalance(vo.getBankAccountName(), "expense", vo.getExpense());
			if(rm==ResultMessage.findIDFailed)
				return ResultMessage.changeFailed;  //在这里的changeFailed代表的是找不到对应银行账户
			else if(rm==ResultMessage.lessThanMin)
				return ResultMessage.lessThanMin; //银行账户余额不足以支出
			else if(rm==ResultMessage.Failed)
				return ResultMessage.Failed; // io/remote错误
			
			expensedata.insert(po);
			return ResultMessage.Success;
			
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return ResultMessage.Failed;
		} 
		
	}

	public ResultMessage deleteExpense(FExpenseVO vo) {
		// TODO 自动生成的方法存根
		FExpensePO po = VOtoPO(vo);
		try {
			
			FExpenseVO original = inquiryExpense(vo.getID());
			if(original==null)
				return ResultMessage.findIDFailed;
			
			bankAccount = new BankAccountManager();
			ResultMessage rm = bankAccount.changeBalance(vo.getBankAccountName(), "income", vo.getExpense());
				
			if(rm==ResultMessage.findIDFailed)
				return ResultMessage.changeFailed; //代表找不到对应的银行账户
			else if(rm==ResultMessage.Failed)
				return ResultMessage.Failed;        //Remote/IO错误
			
			expensedata.delete(po);
			return ResultMessage.Success;
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return ResultMessage.Failed;
		}
		
	}

	public ResultMessage changeExpense(FExpenseVO vo) {
		// TODO 自动生成的方法存根
		
		FExpensePO po = VOtoPO(vo);
		
		try {
			FExpenseVO original = inquiryExpense(vo.getID());
			if(original==null)
				return ResultMessage.findIDFailed;
			
			bankAccount = new BankAccountManager();
			ResultMessage rm = bankAccount.changeBalance(vo.getBankAccountName(), "income", original.getExpense());
			if(rm==ResultMessage.findIDFailed)
				return ResultMessage.changeFailed;  //找不到对应的银行账户，要求用户重新输入银行账户
			else if(rm==ResultMessage.Failed)
				return ResultMessage.Failed;
			
			rm = bankAccount.changeBalance(vo.getBankAccountName(),"expense",vo.getExpense());
			if(rm==ResultMessage.lessThanMin)
				return ResultMessage.lessThanMin;   //更改后的支出额太多，该银行账户余额不够
			else if(rm==ResultMessage.Failed)
				return ResultMessage.Failed;
			//不存在找不到对应账户的错误，因为如果找不到的话在前面就直接返回changefailed信息了
			
			
			expensedata.update(po);
			return ResultMessage.Success;
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return null;
		}
		
	}
	
	public double getTotalEx(String time1,String time2){
		ArrayList<FExpenseVO> expense = new ArrayList<FExpenseVO>();
		double totalEx = 0.0;
		expense = inquiryByTime(time1,time2);
		
		for(int i = 0; i < expense.size(); i++){
			FExpenseVO vo = expense.get(i);
			totalEx += vo.getExpense();
		}
		return totalEx;
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





	public StorageDataService getStorageData() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public StaffDataService getStaffData() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public ArrivalListDataService getArrivalListData() {
		// TODO 自动生成的方法存根
		return null;
	}

	public SendingListDataService getSendingListData() {
		// TODO 自动生成的方法存根
		return null;
	}

	public IncomeListDataService getIncomeListData() {
		// TODO 自动生成的方法存根
		return null;
	}

	public RecivalListDataService getRecivalListData() {
		// TODO 自动生成的方法存根
		return null;
	}

	public LoadingListDataService getLoadingListData() {
		// TODO 自动生成的方法存根
		return null;
	}

	public TransferListDataService getTransferListData() {
		// TODO 自动生成的方法存根
		return null;
	}

	public LoadingListZZDataService getLoadingListZZData() {
		// TODO 自动生成的方法存根
		return null;
	}

	public DriverDataService getDriverData() {
		// TODO 自动生成的方法存根
		return null;
	}

	public CarDataService getCarData() {
		// TODO 自动生成的方法存根
		return null;
	}



	
}
