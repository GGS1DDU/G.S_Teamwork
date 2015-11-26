package elms.dataservice.userdataservice;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import elms.po.UserPO;


public interface UserDataService extends Remote {
	
	public UserPO find(String id) throws RemoteException, IOException;
	
	
	public ArrayList<UserPO> findall() throws RemoteException, IOException;
	
	
	public void insert(UserPO po) throws Exception;
	
	
	public void delete(UserPO po) throws RemoteException;
	
	
	public void update(UserPO po) throws RemoteException;
	
	
	public void init() throws RemoteException;
	
	
	public void finish() throws RemoteException;
	

}