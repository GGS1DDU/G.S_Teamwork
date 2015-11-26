package elms.dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import elms.dataservice.dealdataservice.DealDataService;
import elms.dataservice.financeDataService.FBankAccountDataService;
import elms.dataservice.financeDataService.FExpenseDataService;
import elms.dataservice.financeDataService.FIncomeDataService;
import elms.dataservice.financeDataService.FInitAllDataService;
import elms.dataservice.financeDataService.FStrategyDataService;
import elms.dataservice.userdataservice.UserDataService;

public interface DataFactory  extends Remote{
	public UserDataService getUserData()throws RemoteException;
	public DealDataService getDealData()throws RemoteException;
	
	public FIncomeDataService getIncomeData()throws RemoteException;
	public FExpenseDataService getExpenseData() throws RemoteException;
	public FBankAccountDataService getBankAccountData() throws RemoteException;
	public FStrategyDataService getFreightStrategyData() throws RemoteException;
	public FInitAllDataService getInitData() throws RemoteException;
	
	

}
