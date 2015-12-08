package elms.dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

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
import elms.dataservice.logdataservice.LogDataService;
import elms.dataservice.managerdataservice.FreightStrategyDataService;
import elms.dataservice.managerdataservice.StaffDataService;
import elms.dataservice.memberdataservice.CarDataService;
import elms.dataservice.memberdataservice.DriverDataService;
import elms.dataservice.storagedataservice.StorageDataService;
import elms.dataservice.userdataservice.UserDataService;

public interface DataFactory  extends Remote{
	public UserDataService getUserData()throws RemoteException;
	public DealDataService getDealData()throws RemoteException;
	public LogDataService getLogData() throws RemoteException;
	public StorageDataService getStorageData() throws RemoteException;
	
	public IncomeDataService getIncomeData()throws RemoteException;
	public ExpenseDataService getExpenseData() throws RemoteException;
	public BankAccountDataService getBankAccountData() throws RemoteException;
	public FreightStrategyDataService getFreightStrategyData() throws RemoteException;
	public InitAllDataService getInitData() throws RemoteException;
	
	public StaffDataService getStaffData() throws RemoteException;
	
	public ArrivalListDataService getArrivalListData()throws RemoteException;
	public SendingListDataService getSendingListData() throws RemoteException;
	public IncomeListDataService getIncomeListData() throws RemoteException;
	public RecivalListDataService getRecivalListData() throws RemoteException;
	public LoadingListDataService getLoadingListData() throws RemoteException;
	public TransferListDataService getTransferListData() throws RemoteException;
	public LoadingListZZDataService getLoadingListZZData() throws RemoteException;
	
	public DriverDataService getDriverData() throws RemoteException;
	public CarDataService getCarData() throws RemoteException;

}
