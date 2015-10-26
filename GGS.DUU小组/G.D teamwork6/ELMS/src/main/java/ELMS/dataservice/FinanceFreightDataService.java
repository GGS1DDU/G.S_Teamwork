package ELMS.dataservice;

import java.rmi.RemoteException;

import ELMS.po.FreightStrategyPO;

public interface FinanceFreightDataService {
	
	public void update(FreightStrategyPO po) throws RemoteException;
	
	public void finish() throws RemoteException;
}
