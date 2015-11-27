package elms.data;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import elms.data.dealdata.DealData;
import elms.data.logdata.LogData;
import elms.data.storagedata.StorageData;
import elms.data.userdata.UserData;
import elms.dataservice.DataFactory;
import elms.dataservice.dealdataservice.DealDataService;
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
	

}
