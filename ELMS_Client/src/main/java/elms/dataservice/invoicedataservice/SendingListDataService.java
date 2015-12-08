package elms.dataservice.invoicedataservice;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import elms.po.SendingListPO;

public interface SendingListDataService extends Remote{

	public SendingListPO find(String id) throws RemoteException, IOException;
	
	public void insert(SendingListPO po) throws RemoteException, IOException;
	
	
	public void delete(SendingListPO po) throws RemoteException, IOException;
	
	
	public void update(SendingListPO po) throws RemoteException, IOException;
	
	
	public void init() throws RemoteException;
	
	
	public void finish() throws RemoteException;
	
	

}
