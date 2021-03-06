package elms.dataservice.financedataservice;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import elms.po.AccountPO;

public interface InitAllDataService extends Remote{

	public void  initAll(String time) throws RemoteException, IOException, ClassNotFoundException;
		
	public void recovery(String time) throws RemoteException, FileNotFoundException, IOException, ClassNotFoundException;
	  
	public void  copy(String time) throws RemoteException, FileNotFoundException, IOException, ClassNotFoundException;
	public boolean getInitState(int a) throws RemoteException;
	public  void  addAccount(AccountPO po) throws IOException;
	public ArrayList<AccountPO> getAccount() throws ClassNotFoundException, IOException;
	public void setInitState() throws RemoteException;
	public void setInitState(int a) throws RemoteException;
}
