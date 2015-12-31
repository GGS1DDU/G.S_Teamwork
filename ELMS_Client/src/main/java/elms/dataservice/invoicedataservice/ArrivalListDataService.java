package elms.dataservice.invoicedataservice;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import elms.po.ArrivalListPO;

public interface ArrivalListDataService extends Remote{
	
	public ArrivalListPO find(String id) throws RemoteException, IOException;
	
		
	public void insert(ArrivalListPO po) throws RemoteException, IOException;
	
	
	public void delete(ArrivalListPO po) throws RemoteException, IOException;
	
	
	public void update(ArrivalListPO po) throws RemoteException, IOException;
	
	
	public ArrayList<ArrivalListPO> findall() throws RemoteException,IOException;

	
	public ArrayList<ArrivalListPO> findbymaker(String maker) throws RemoteException, IOException;
	
	
	public void init() throws RemoteException;
	
	
	public void finish() throws RemoteException;
	

}
