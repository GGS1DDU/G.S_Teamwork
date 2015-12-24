package elms.dataservice.invoicedataservice;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import elms.po.IncomeListPO;

public interface IncomeListDataService extends Remote{

	public IncomeListPO find(String id) throws RemoteException, IOException;
	
	
	public void insert(IncomeListPO po) throws RemoteException, IOException;
	
	
	public void delete(IncomeListPO po) throws RemoteException, IOException;
	
	
	public void update(IncomeListPO po) throws RemoteException, IOException;
	
	
	public ArrayList<IncomeListPO> findall() throws RemoteException,IOException;
	
	
	public void init() throws RemoteException;
	
	
	public void finish() throws RemoteException;
	

}
