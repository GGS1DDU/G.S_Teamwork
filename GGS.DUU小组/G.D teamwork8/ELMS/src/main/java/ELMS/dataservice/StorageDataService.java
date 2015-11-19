package ELMS.dataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import ELMS.po.StoragePO;


public interface StorageDataService {
	public StoragePO find(String id) throws RemoteException;
	public ArrayList<StoragePO> findall(String center) throws RemoteException;
	public ArrayList<StoragePO>findbytime(String time1,String time2,String center)throws RemoteException;
	public void insert(StoragePO po) throws RemoteException;
	public void delete(StoragePO po) throws RemoteException;
	public void update(StoragePO po) throws RemoteException;
	public void init() throws RemoteException;
	public void finish() throws RemoteException;
}
