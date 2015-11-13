package elms.dataservice.dealdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import elms.po.DealPO;

public interface DealDataService {
	
public DealPO find(Long id) throws RemoteException;

	
	public ArrayList<DealPO> findall() throws RemoteException;
	
	
	public ArrayList<DealPO> findbyCourier(String courier,String dealtime) throws RemoteException;
	
	
	public ArrayList<DealPO> findbyHall(String hall) throws RemoteException;
	
	
	public void insert(DealPO po) throws RemoteException;
	
	
	public void delete(DealPO po) throws RemoteException;
	
	
	public void update(DealPO po) throws RemoteException;
	
	
	public void init() throws RemoteException;
	
	
	public void finish() throws RemoteException;

}
