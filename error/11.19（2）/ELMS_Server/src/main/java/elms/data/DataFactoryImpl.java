package elms.data;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import elms.data.dealdata.DealData;
import elms.data.financedata.BankAccountData;
import elms.data.financedata.ExpenseData;
import elms.data.financedata.FreightStrategyData;
import elms.data.financedata.IncomeData;
import elms.data.financedata.InitAllData;
import elms.data.userdata.UserData;
import elms.dataservice.DataFactory;
import elms.dataservice.dealdataservice.DealDataService;
import elms.dataservice.financeDataService.FBankAccountDataService;
import elms.dataservice.financeDataService.FExpenseDataService;
import elms.dataservice.financeDataService.FIncomeDataService;
import elms.dataservice.financeDataService.FInitAllDataService;
import elms.dataservice.financeDataService.FStrategyDataService;
import elms.dataservice.userdataservice.UserDataService;

public class DataFactoryImpl extends UnicastRemoteObject implements DataFactory  {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DataFactoryImpl() throws RemoteException {
		super();
	}

	public UserDataService getUserData() throws RemoteException{
		UserDataService userdata=null;
		try {
			userdata = new UserData();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return userdata;
	}

	public DealDataService getDealData()throws RemoteException {
		DealDataService dealdata=null;
		try {
			dealdata = new DealData();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return dealdata;
		
	}

	public FIncomeDataService getIncomeData() throws RemoteException {
		FIncomeDataService incomedata = null;
		try {
			incomedata = new IncomeData();
		} catch (Exception e) {
			System.out.println("server: can't get income data");
			e.printStackTrace();
		} 
		System.out.println(incomedata==null);
		return incomedata;
	}

	public FExpenseDataService getExpenseData() throws RemoteException {
		FExpenseDataService expensedata = null;
		try {
			expensedata = new ExpenseData();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return expensedata;
	}

	public FBankAccountDataService getBankAccountData() throws RemoteException {
		FBankAccountDataService bankaccountdata = null;
		try {
			bankaccountdata = new BankAccountData();
			System.out.println("Server data factory impl: 12345!");
		} catch (Exception e) {
			System.out.println("Server data factory impl: failed!");
			e.printStackTrace();
		} 
		return bankaccountdata;
	}

	public FStrategyDataService getFreightStrategyData() throws RemoteException {
		FStrategyDataService strategydata = null;
		try {
			strategydata = new FreightStrategyData();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return strategydata;
	}

	public FInitAllDataService getInitData() throws RemoteException {
		FInitAllDataService initdata = null;
		try {
			initdata = new InitAllData();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return initdata;
	}

	
	

}
