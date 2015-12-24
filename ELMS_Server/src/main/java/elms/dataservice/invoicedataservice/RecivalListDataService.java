package elms.dataservice.invoicedataservice;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import elms.po.RecivalListPO;

public interface RecivalListDataService extends Remote{

	public RecivalListPO find(String id) throws RemoteException, IOException;
	
	
	public void insert(RecivalListPO po) throws RemoteException, IOException;
	
	
	public void delete(RecivalListPO po) throws RemoteException, IOException;
	
	
	public void update(RecivalListPO po) throws RemoteException, IOException;
	
	
	public ArrayList<RecivalListPO> findall() throws RemoteException,IOException;
	
	
	public void init() throws RemoteException;
	
	
	public void finish() throws RemoteException;
	

}
