package elms.dataservice.invoicedataservice;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import elms.po.LoadingListPO;



public interface LoadingListDataService extends Remote{
    public LoadingListPO find(String id) throws RemoteException, IOException;
	
	public void insert(LoadingListPO po) throws RemoteException, IOException;
	
	
	public void delete(LoadingListPO po) throws RemoteException, IOException;
	
	
	public void update(LoadingListPO po) throws RemoteException, IOException;
	
	
	public void init() throws RemoteException;
	
	
	public void finish() throws RemoteException;

}
