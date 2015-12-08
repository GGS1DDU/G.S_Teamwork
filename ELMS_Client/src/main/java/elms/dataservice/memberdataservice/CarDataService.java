package elms.dataservice.memberdataservice;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import elms.po.CarPO;

public interface CarDataService extends Remote{

	public CarPO find(String id) throws RemoteException, IOException;
	
	
	public void insert(CarPO po) throws RemoteException, IOException;
	
	
	public void delete(CarPO po) throws RemoteException, IOException;
	
	
	public void update(CarPO po) throws RemoteException, IOException;
	
	
	public void init() throws RemoteException;
	
	
	public void finish() throws RemoteException;

}
