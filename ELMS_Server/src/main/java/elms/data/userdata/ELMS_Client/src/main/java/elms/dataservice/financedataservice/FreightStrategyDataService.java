package elms.dataservice.financedataservice;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import elms.po.FreightStrategyPO;

public interface FreightStrategyDataService extends Remote{

	public FreightStrategyPO find(String id) throws RemoteException, IOException;
	
	public void init() throws RemoteException;
	
	public void insert(FreightStrategyPO po) throws RemoteException;
	
	public void delete(FreightStrategyPO po) throws RemoteException;
	
	public void update(FreightStrategyPO po) throws RemoteException;
}
