package ELMS.dataservice;
/**
 * 作者:郑闻昊
 */
import java.rmi.RemoteException;
import java.util.ArrayList;
import ELMS.po.DealPO;

public interface DealDataService {
	
public DealPO find(Long id) throws RemoteException;

	
	public ArrayList<DealPO> findall() throws RemoteException;
	
	
	public ArrayList<DealPO> findbyCourier(String courier) throws RemoteException;
	
	
	public ArrayList<DealPO> findbyHall(String hall) throws RemoteException;
	
	
	public void insert(DealPO po) throws RemoteException;
	
	
	public void delete(DealPO po) throws RemoteException;
	
	
	public void update(DealPO po) throws RemoteException;
	
	
	public void init() throws RemoteException;
	
	
	public void finish() throws RemoteException;

}
