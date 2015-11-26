package elms.dataservice.financeDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FInitAllDataService extends Remote{
	
	public boolean initAll(String operator) throws RemoteException;//�ڳ����˽������˻�
	
	public void delete() throws RemoteException;
		
	public boolean save(String operator) throws RemoteException;//�ڳ����˱���
		
}
