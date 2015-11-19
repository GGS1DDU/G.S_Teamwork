package ELMS.data.FinanceData;

import java.rmi.RemoteException;
import java.util.ArrayList;

import ELMS.dataservice.FinanceDataService;
import ELMS.po.BankAccountPO;
import ELMS.po.FExpensePO;
import ELMS.po.FIncomePO;
import ELMS.po.FreightStrategyPO;
import ELMS.vo.FreightStrategyVO;

public class FinanceData implements FinanceDataService{

	public FIncomePO findIncome(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public FExpensePO findExpense(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public ArrayList<FIncomePO> findbyHall(String hall) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public ArrayList<FIncomePO> findIncome(String time1, String time2)
			throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public ArrayList<FIncomePO> findHallIncome(String time1, String time2,
			String hall) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public ArrayList<FExpensePO> findExpense(String time1, String time2)
			throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public void insertExpense(FExpensePO po) throws RemoteException {
		// TODO 自动生成的方法存根
		
	}

	public void deleteExpense(FExpensePO po) throws RemoteException {
		// TODO 自动生成的方法存根
		
	}

	public void updateExpense(FExpensePO po) throws RemoteException {
		// TODO 自动生成的方法存根
		
	}

	public boolean initAll(String operator) throws RemoteException {
		// TODO 自动生成的方法存根
		return false;
	}

	public boolean save(String operator) throws RemoteException {
		// TODO 自动生成的方法存根
		return false;
	}

	public FreightStrategyVO find() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public void initFreight() throws RemoteException {
		// TODO 自动生成的方法存根
		
	}

	public FreightStrategyPO add(FreightStrategyVO vo) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public void delete(FreightStrategyPO po) throws RemoteException {
		// TODO 自动生成的方法存根
		
	}

	public void update(FreightStrategyPO po) throws RemoteException {
		// TODO 自动生成的方法存根
		
	}

	public BankAccountPO find(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public ArrayList<BankAccountPO> findByBank(String bankName)
			throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public void insertAccount(BankAccountPO po) throws RemoteException {
		// TODO 自动生成的方法存根
		
	}

	public void deleteAccount(String accountID) throws RemoteException {
		// TODO 自动生成的方法存根
		
	}

	public void updateAccount(BankAccountPO po) throws RemoteException {
		// TODO 自动生成的方法存根
		
	}

	public void initAccount() throws RemoteException {
		// TODO 自动生成的方法存根
		
	}

	public void initInAndEx() throws RemoteException {
		// TODO 自动生成的方法存根
		
	}

	public void finish() throws RemoteException {
		// TODO 自动生成的方法存根
		
	}

	public void insertIncome(FIncomePO po) throws RemoteException {
		// TODO 自动生成的方法存根
		
	}

}
