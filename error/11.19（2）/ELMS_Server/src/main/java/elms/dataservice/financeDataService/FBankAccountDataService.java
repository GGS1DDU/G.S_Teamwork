package elms.dataservice.financeDataService;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import elms.po.BankAccountPO;

public interface FBankAccountDataService extends Remote{

	public BankAccountPO find(String id) throws RemoteException, IOException;
	
	public ArrayList<BankAccountPO> findByBank(String bankName) throws RemoteException, IOException;
	
	public void insert(BankAccountPO po) throws RemoteException, IOException;
	
	public void delete(String accountID) throws RemoteException;
	
	public void update(BankAccountPO po) throws RemoteException;
	
	public void init() throws RemoteException;
}
