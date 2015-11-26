package elms.dataservice.financedataservice;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import elms.po.FIncomePO;

public interface FIncomeDataService extends Remote{

	public void insert(FIncomePO po) throws RemoteException, IOException;
	
	public void delete(FIncomePO po) throws RemoteException;
	
	public void update(FIncomePO po) throws RemoteException;
	
	public FIncomePO find(String id) throws RemoteException, IOException;
	
	public ArrayList<FIncomePO> findbyHall(String hall) throws RemoteException, IOException;
	
	public ArrayList<FIncomePO> findByTime(String time1,String time2) throws RemoteException, IOException;
	
	public ArrayList<FIncomePO> findHallTime(String time1,String time2,String hall) throws RemoteException, IOException;
	
	public void init() throws RemoteException;
}
