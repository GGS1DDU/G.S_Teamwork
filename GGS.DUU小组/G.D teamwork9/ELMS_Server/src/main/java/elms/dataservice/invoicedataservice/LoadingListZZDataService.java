package elms.dataservice.invoicedataservice;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import elms.po.LoadingListZZPO;

public interface LoadingListZZDataService extends Remote{

	public LoadingListZZPO find(String id) throws RemoteException, IOException;
	
	
	public void insert(LoadingListZZPO po) throws RemoteException, IOException;
	
	
	public void delete(LoadingListZZPO po) throws RemoteException, IOException;
	
	
	public void update(LoadingListZZPO po) throws RemoteException, IOException;
	
	
	public void init() throws RemoteException;
	
	
	public void finish() throws RemoteException;
}
