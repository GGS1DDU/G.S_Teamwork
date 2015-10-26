package ELMS.data.FinanceData;

import java.rmi.RemoteException;
import java.util.ArrayList;

import ELMS.dataservice.FinanceBankDataService;
import ELMS.po.BankAccountPO;


public class BankData_Stub implements FinanceBankDataService{

	public BankAccountPO find(String id) throws RemoteException {
		// TODO �Զ����ɵķ������
		return new BankAccountPO("po00001",100,"中国工商银行");
	}

	public ArrayList<BankAccountPO> findByBank(String bankName)
			throws RemoteException {
		// TODO �Զ����ɵķ������
		ArrayList<BankAccountPO> bap = new ArrayList<BankAccountPO>();
		bap.add(new BankAccountPO("po00001",100,"中国工商银行"));
		bap.add(new BankAccountPO("po00002",100,"中国工商银行"));
		bap.add(new BankAccountPO("po00003",100,"中国工商银行"));
		return bap;
	}

	public void insert(BankAccountPO po) throws RemoteException {
		// TODO �Զ����ɵķ������
		System.out.println("insert successfully!");
		
	}

	public void delete(BankAccountPO po) throws RemoteException {
		// TODO �Զ����ɵķ������
		System.out.println("Delete successfully!");
		
	}

	public void update(BankAccountPO po) throws RemoteException {
		// TODO �Զ����ɵķ������
		System.out.println("update successfully!");
	}

	public void init() throws RemoteException {
		// TODO �Զ����ɵķ������
		System.out.println("init successfully!");
	}

	public void finish() throws RemoteException {
		// TODO �Զ����ɵķ������
		
	}

}
