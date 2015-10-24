package ELMS.dataservice;


import java.rmi.RemoteException;
import java.util.ArrayList;
import ELMS.po.UserPO;


public interface UserDataService {
	
	public UserPO find(Long id) throws RemoteException;
	
	
	public ArrayList<UserPO> findall() throws RemoteException;
	
	
	public void insert(UserPO po) throws RemoteException;
	
	
	public void delete(UserPO po) throws RemoteException;
	
	
	public void update(UserPO po) throws RemoteException;
	
	
	public void init() throws RemoteException;
	
	
	public void finish() throws RemoteException;
	

}
