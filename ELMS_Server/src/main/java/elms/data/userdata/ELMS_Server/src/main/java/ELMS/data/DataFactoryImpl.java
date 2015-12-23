package elms.data;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import elms.data.dealdata.DealData;
import elms.data.financedata.BankAccountData;
import elms.data.financedata.ExpenseData;
import elms.data.financedata.FreightStrategyData;
import elms.data.financedata.IncomeData;
import elms.data.financedata.InitAllData;
import elms.data.logdata.LogData;
import elms.data.storagedata.StorageData;
import elms.data.userdata.UserData;
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

public class DataFactoryImpl extends UnicastRemoteObject implements DataFactory  {


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

	public LogDataService getLogData() throws RemoteException {
		LogDataService logdata=null;
		try {
			logdata = new LogData();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return logdata;
	}

	public StorageDataService getStorageData() throws RemoteException {
		StorageDataService storagedata=null;
		try {
			storagedata = new StorageData();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return storagedata;
	}
	
	public IncomeDataService getIncomeData() throws RemoteException {
		IncomeDataService incomedata = null;
		try {
			incomedata = new IncomeData();
		} catch (Exception e) {
			System.out.println("server: can't get income data");
			e.printStackTrace();
		} 
		System.out.println(incomedata==null);
		return incomedata;
	}

	public ExpenseDataService getExpenseData() throws RemoteException {
		ExpenseDataService expensedata = null;
		try {
			expensedata = new ExpenseData();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return expensedata;
	}

	public BankAccountDataService getBankAccountData() throws RemoteException {
		BankAccountDataService bankaccountdata = null;
		try {
			bankaccountdata = new BankAccountData();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
		return bankaccountdata;
	}

	public FreightStrategyDataService getFreightStrategyData() throws RemoteException {
		FreightStrategyDataService strategydata = null;
		try {
			strategydata = new FreightStrategyData();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return strategydata;
	}

	public InitAllDataService getInitData() throws RemoteException {
		InitAllDataService initdata = null;
		try {
			initdata = new InitAllData();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return initdata;
	}
	

}