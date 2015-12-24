package elms.dataservice.memberdataservice;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import elms.po.DriverPO;

public interface DriverDataService extends Remote{

	public DriverPO find(String id) throws RemoteException, IOException;
	
	
	public void insert(DriverPO po) throws RemoteException, IOException;
	
	
	public void delete(DriverPO po) throws RemoteException, IOException;
	
	
	public void update(DriverPO po) throws RemoteException, IOException;
	
	
	public ArrayList<DriverPO> findall() throws RemoteException,IOException;
	
	
	public void init() throws RemoteException;
	
	
	public void finish() throws RemoteException;
}
