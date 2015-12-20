package elms.dataservice.dealdataservice;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import elms.po.DealPO;

public interface DealDataService extends Remote{
	
public DealPO find(String id) throws RemoteException,IOException;

	
	public ArrayList<DealPO> findall() throws IOException;
	
	
	public ArrayList<DealPO> findbyCourier(String courier,String dealtime) throws RemoteException;
	
	
	public ArrayList<DealPO> findbyHall(String hall) throws RemoteException;
	
	
	public void insert(DealPO po) throws RemoteException,IOException;
	
	
	public void delete(DealPO po) throws RemoteException,IOException;
	
	
	public void update(DealPO po) throws RemoteException,IOException;
	
	
	public void init() throws RemoteException;
	
	
	public void finish() throws RemoteException;

}
