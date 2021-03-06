package ELMS.dataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import ELMS.po.BankAccountPO;


public interface FinanceBankDataService {
	public BankAccountPO find(String id) throws RemoteException;
	
	public ArrayList<BankAccountPO> findByBank(String bankName) throws RemoteException;
	
	public void insert(BankAccountPO po) throws RemoteException;
	
	public void delete(BankAccountPO po) throws RemoteException;
	
	public void update(BankAccountPO po) throws RemoteException;
	
	public void init() throws RemoteException;
	
	public void finish() throws RemoteException;
}
