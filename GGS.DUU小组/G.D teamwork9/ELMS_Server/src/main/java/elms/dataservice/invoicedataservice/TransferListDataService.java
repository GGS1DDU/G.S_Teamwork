package elms.dataservice.invoicedataservice;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import elms.po.TransferListPO;

public interface TransferListDataService extends Remote{

	public TransferListPO find(String id) throws RemoteException, IOException;
	
	
	public void insert(TransferListPO po) throws RemoteException, IOException;
	
	
	public void delete(TransferListPO po) throws RemoteException, IOException;
	
	
	public void update(TransferListPO po) throws RemoteException, IOException;
	
	
	public void init() throws RemoteException;
	
	
	public void finish() throws RemoteException;

}
