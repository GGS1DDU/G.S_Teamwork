package elms.data.dealdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;



import elms.dataservice.dealdataservice.DealDataService;
import elms.po.DealPO;
public class DealData extends UnicastRemoteObject implements DealDataService {

	public DealData() throws RemoteException  {
		super();
	}

	public DealPO find(Long id) throws RemoteException {
		return null;
	}

	public ArrayList<DealPO> findall() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<DealPO> findbyCourier(String courier, String dealtime)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<DealPO> findbyHall(String hall) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public void insert(DealPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public void delete(DealPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public void update(DealPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	

}