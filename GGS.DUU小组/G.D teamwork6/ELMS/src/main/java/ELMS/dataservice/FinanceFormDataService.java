package ELMS.dataservice;

import java.rmi.RemoteException;

public interface FinanceFormDataService {
	public boolean init(String operator) throws RemoteException;//�ڳ����˽������˻�
	
	public boolean save(String operator) throws RemoteException;//�ڳ����˱���
	
	public boolean create(String time1, String time2) throws RemoteException;//��������
	
	public void finish() throws RemoteException;
}
