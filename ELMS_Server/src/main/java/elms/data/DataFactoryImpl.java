package elms.data;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import elms.data.dealdata.DealData;
import elms.data.userdata.UserData;
import elms.dataservice.DataFactory;
import elms.dataservice.dealdataservice.DealDataService;
import elms.dataservice.userdataservice.UserDataService;

public class DataFactoryImpl extends UnicastRemoteObject implements DataFactory  {


	public DataFactoryImpl() throws RemoteException {
		super();
	}

	public UserDataService getUserData() throws RemoteException{
		UserDataService userdata=null;
		try {
			userdata = new UserData();
		} catch (RemoteException e) {
			e.printStackTrace();
		} 
		
		return userdata;
	}

	public DealDataService getDealData()throws RemoteException {
		DealDataService dealdata=null;
		try {
			dealdata = new DealData();
		} catch (RemoteException e) {
			e.printStackTrace();
		} 
		return dealdata;
		
	}
	

}
