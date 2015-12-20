package elms.dataservice.financedataservice;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import elms.po.BankAccountPO;

public interface BankAccountDataService extends Remote{

	//银行账户名是唯一的吗？检索的时候是按照账户id还是账户名？
	public BankAccountPO find(String id) throws RemoteException, IOException;
	
	public ArrayList<BankAccountPO> findByBank(String bankName) throws RemoteException, IOException;
	
	public boolean insert(BankAccountPO po) throws RemoteException, IOException;
	
	public boolean delete(String accountID) throws RemoteException;
	
	public boolean update(BankAccountPO po) throws RemoteException;
	
	public void init() throws RemoteException;
	
	public ArrayList<BankAccountPO> findAll() throws RemoteException, IOException;
	
	public boolean isEmpty() throws RemoteException, IOException;
}
