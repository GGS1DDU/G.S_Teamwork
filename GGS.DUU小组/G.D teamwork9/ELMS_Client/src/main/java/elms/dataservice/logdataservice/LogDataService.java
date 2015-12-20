package elms.dataservice.logdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import elms.po.LogPO;



public interface LogDataService extends Remote{
	public LogPO find(String id) throws RemoteException;
	public ArrayList<LogPO> findAll() throws RemoteException;
	public ArrayList<LogPO> findbyID(String ID)throws RemoteException;
	public void insert(LogPO po) throws RemoteException;
	public void init() throws RemoteException;
	public void finish() throws RemoteException;
}
