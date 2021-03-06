package ELMS.dataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;


import ELMS.po.FIncomePO;
import ELMS.po.FExpensePO;


public interface FinanceInAndExDataService {
	public FIncomePO findIncome(Long id) throws RemoteException;
	
	public FExpensePO findExpense(Long id) throws RemoteException;
	
	public ArrayList<FIncomePO> findbyHall(String hall) throws RemoteException;
	
	public ArrayList<FIncomePO> findIncome(String time1,String time2) throws RemoteException;
	
	public ArrayList<FIncomePO> findHallIncome(String time1,String time2,String hall) throws RemoteException;
	
	public ArrayList<FExpensePO> findExpense(String time1,String time2) throws RemoteException;
	
	public void insertIncome(FIncomePO po) throws RemoteException;
	
	public void deleteIncome(FIncomePO po) throws RemoteException;
	
	public void updateIncome(FIncomePO po) throws RemoteException;
	
	public void insertExpense(FExpensePO po) throws RemoteException;
	
	public void deleteExpense(FExpensePO po) throws RemoteException;
	
	public void updateExpense(FExpensePO po) throws RemoteException;
	
	public void init() throws RemoteException;
	
	public void finish() throws RemoteException;
	
}
