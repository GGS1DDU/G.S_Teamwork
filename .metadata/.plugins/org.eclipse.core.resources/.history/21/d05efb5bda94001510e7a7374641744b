package elms.dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import elms.dataservice.dealdataservice.DealDataService;
import elms.dataservice.logdataservice.LogDataService;
import elms.dataservice.storagedataservice.StorageDataService;
import elms.dataservice.userdataservice.UserDataService;

public interface DataFactory  extends Remote{
	public UserDataService getUserData()throws RemoteException;
	public DealDataService getDealData()throws RemoteException;
	public LogDataService getLogData() throws RemoteException;
	public StorageDataService getStorageData() throws RemoteException;

}
