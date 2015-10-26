package ELMS.dataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import ELMS.po.LogPO;


public interface LogDataService {
	public LogPO find(String id) throws RemoteException;
	public ArrayList<LogPO> findAll() throws RemoteException;
	public ArrayList<LogPO> findbyID(String ID)throws RemoteException;
	public void insert(LogPO po) throws RemoteException;
	public void init() throws RemoteException;
	public void finish() throws RemoteException;
}
