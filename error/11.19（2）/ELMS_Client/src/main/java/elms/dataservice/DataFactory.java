package elms.dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import elms.dataservice.dealdataservice.DealDataService;
import elms.dataservice.financedataservice.FBankAccountDataService;
import elms.dataservice.financedataservice.FExpenseDataService;
import elms.dataservice.financedataservice.FIncomeDataService;
import elms.dataservice.financedataservice.FInitAllDataService;
import elms.dataservice.financedataservice.FStrategyDataService;
import elms.dataservice.userdataservice.UserDataService;

public interface DataFactory extends Remote{
	public UserDataService getUserData();
	public DealDataService getDealData();

	public FIncomeDataService getIncomeData()throws RemoteException;
	public FExpenseDataService getExpenseData() throws RemoteException;
	public FBankAccountDataService getBankAccountData() throws RemoteException;
	public FStrategyDataService getFreightStrategyData() throws RemoteException;
	public FInitAllDataService getInitData() throws RemoteException;
}
