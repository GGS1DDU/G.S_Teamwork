package ELMS.dataservice;


import java.rmi.RemoteException;
import java.util.ArrayList;






import ELMS.po.BankAccountPO;
import ELMS.po.FIncomePO;
import ELMS.po.FExpensePO;
import ELMS.po.FreightStrategyPO;
import ELMS.vo.FIncomeVO;
import ELMS.vo.FreightStrategyVO;


public interface FinanceDataService {
	public void insertIncome(FIncomePO po) throws RemoteException;
	
	public FIncomePO findIncome(String id) throws RemoteException;
	
	public FExpensePO findExpense(String id) throws RemoteException;
	
	public ArrayList<FIncomePO> findbyHall(String hall) throws RemoteException;
	
	public ArrayList<FIncomePO> findIncome(String time1,String time2) throws RemoteException;
	
	public ArrayList<FIncomePO> findHallIncome(String time1,String time2,String hall) throws RemoteException;
	
	public ArrayList<FExpensePO> findExpense(String time1,String time2) throws RemoteException;
	
//	public void insertIncome(FIncomePO po) throws RemoteException;
//	
//	public void deleteIncome(FIncomePO po) throws RemoteException;
//	
//	public void updateIncome(FIncomePO po) throws RemoteException;
//	
	public void insertExpense(FExpensePO po) throws RemoteException;
	
	public void deleteExpense(FExpensePO po) throws RemoteException;
	
	public void updateExpense(FExpensePO po) throws RemoteException;
	
	
	
    public boolean initAll(String operator) throws RemoteException;//�ڳ����˽������˻�
	
	public boolean save(String operator) throws RemoteException;//�ڳ����˱���
	
	
	
	public FreightStrategyVO find() throws RemoteException;
	
	public void initFreight() throws RemoteException;
	
	public FreightStrategyPO add(FreightStrategyVO vo) throws RemoteException;
	
	public void delete(FreightStrategyPO po) throws RemoteException;
	
	public void update(FreightStrategyPO po) throws RemoteException;
	
	
	
	public BankAccountPO find(String id) throws RemoteException;
	
	public ArrayList<BankAccountPO> findByBank(String bankName) throws RemoteException;
	
	public void insertAccount(BankAccountPO po) throws RemoteException;
	
	public void deleteAccount(String accountID) throws RemoteException;
	
	public void updateAccount(BankAccountPO po) throws RemoteException;
	
	public void initAccount() throws RemoteException;
	
	
	
	public void initInAndEx() throws RemoteException;
	
	public void finish() throws RemoteException;
	
}
