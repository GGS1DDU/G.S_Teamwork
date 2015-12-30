package elms.data;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import elms.data.dealdata.DealData;
import elms.data.financedata.BankAccountData;
import elms.data.financedata.ExpenseData;
import elms.data.financedata.IncomeData;
import elms.data.financedata.InitAllData;
import elms.data.invoicedata.ArrivalListData;
import elms.data.invoicedata.IncomeListData;
import elms.data.invoicedata.LoadingListData;
import elms.data.invoicedata.LoadingListZZData;
import elms.data.invoicedata.RecivalListData;
import elms.data.invoicedata.SendingListData;
import elms.data.invoicedata.TransferListData;

import elms.data.managerdata.FreightStrategyData;
import elms.data.managerdata.StaffData;
import elms.data.memberdata.CarData;
import elms.data.memberdata.DriverData;
import elms.data.storagedata.StorageData;
import elms.data.userdata.UserData;
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

	

	public StaffDataService getStaffData() throws RemoteException {
		// TODO 自动生成的方法存根
		StaffDataService staffdata = null;
		try {
			staffdata = new StaffData();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return staffdata;
		
	}
	
	public ArrivalListDataService getArrivalListData() throws RemoteException {
		ArrivalListDataService arrivallistdata=null;
		try{
			arrivallistdata=new ArrivalListData();
		}catch(Exception e){
			e.printStackTrace();
		}
		return arrivallistdata;
	}
	
	public SendingListDataService getSendingListData() throws RemoteException{
		SendingListDataService sendinglistdata=null;
		try{
			sendinglistdata=new SendingListData();
		}catch(Exception e){
			e.printStackTrace();
		}
		return sendinglistdata;
	}

	public IncomeListDataService getIncomeListData() throws RemoteException {
		IncomeListDataService incomelistdata=null;
		try{
			incomelistdata=new IncomeListData();
		}catch(Exception e){
			e.printStackTrace();
		}
		return incomelistdata;
	}

	public RecivalListDataService getRecivalListData() throws RemoteException {
		RecivalListDataService recivallistdata=null;
		try{
			recivallistdata=new RecivalListData();
		}catch(Exception e){
			e.printStackTrace();
		}
		return recivallistdata;
	}

	public LoadingListDataService getLoadingListData() throws RemoteException {
		LoadingListDataService loadinglistdata=null;
		try{
			loadinglistdata=new LoadingListData();
		}catch(Exception e){
			e.printStackTrace();
		}
		return loadinglistdata;
	}

	public TransferListDataService getTransferListData() throws RemoteException {
		TransferListDataService transferlistdata=null;
		try{
			transferlistdata=new TransferListData();
		}catch(Exception e){
			e.printStackTrace();
		}
		return transferlistdata;
	}

	public LoadingListZZDataService getLoadingListZZData() throws RemoteException {
		LoadingListZZDataService loadinglistzzdata=null;
		try{
			loadinglistzzdata=new LoadingListZZData();
		}catch(Exception e){
			e.printStackTrace();
		}
		return loadinglistzzdata;
	}

	public DriverDataService getDriverData() throws RemoteException {
		DriverDataService driverdata=null;
		try{
			driverdata=new DriverData();
		}catch(Exception e){
			e.printStackTrace();
		}
		return driverdata;
	}

	public CarDataService getCarData() throws RemoteException {
		CarDataService cardata=null;
		try{
			cardata=new CarData();
		}catch(Exception e){
			e.printStackTrace();
		}
		return cardata;
	}
	

}
