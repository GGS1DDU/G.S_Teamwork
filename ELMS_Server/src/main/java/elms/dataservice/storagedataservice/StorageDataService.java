package elms.dataservice.storagedataservice;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.ArrayList;

import elms.po.StoragePO;


public interface StorageDataService extends Remote {
	public StoragePO find(String id) throws RemoteException, IOException;
	public ArrayList<StoragePO> findall(String center) throws RemoteException,IOException;
	public ArrayList<StoragePO>findbytime(String time1,String time2,String center)throws RemoteException, IOException, ParseException;
	public void insert(StoragePO po) throws RemoteException, IOException;
	public void delete(StoragePO po) throws RemoteException, IOException;
	public void update(StoragePO po) throws RemoteException, IOException;
	public void init() throws RemoteException;
	public void finish() throws RemoteException;
	public void setIn(String s)throws RemoteException,IOException ;
	public void setOut(String s)throws RemoteException,IOException ;
	public void getIn(int s)throws RemoteException,IOException ;
	public void getOut(int s)throws RemoteException,IOException ;
	public ArrayList<String> getallin() throws RemoteException,IOException;
	public ArrayList<String> getallout() throws RemoteException,IOException;
}
