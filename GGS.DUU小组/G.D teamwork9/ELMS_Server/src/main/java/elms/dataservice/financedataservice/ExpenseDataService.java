package elms.dataservice.financedataservice;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import elms.po.FExpensePO;

public interface ExpenseDataService extends Remote{

	public FExpensePO find(String id) throws RemoteException, IOException;
	
	public ArrayList<FExpensePO> findByTime(String time1,String time2) throws RemoteException, IOException;
		
	public ArrayList<FExpensePO> findAll() throws RemoteException;
	
	public void insert(FExpensePO po) throws RemoteException, IOException;
	
	public void delete(FExpensePO po) throws RemoteException;
	
	public void update(FExpensePO po) throws RemoteException;
	
	
}
