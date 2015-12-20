package elms.dataservice.managerdataservice;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import elms.po.StaffPO;


public interface StaffDataService extends Remote{

	public StaffPO find(String id) throws RemoteException, IOException;
	
	
	public ArrayList<StaffPO> findall() throws RemoteException, IOException;
	
	
	public void insert(StaffPO po) throws Exception;
	
	
	public void delete(StaffPO po) throws RemoteException;
	
	
	public void update(StaffPO po) throws RemoteException;
	
	
	public void init() throws RemoteException;
	
	
	public void finish() throws RemoteException;
	
}
