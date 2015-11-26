package elms.businesslogic_service.financeblservice;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import elms.po.BankAccountPO;
import elms.vo.BankAccountVO;

public interface BankAccountBlService {
	public boolean addAccount(BankAccountVO vo) throws RemoteException;
	
	public boolean deleteAccount(String bankAccount);
	
	public BankAccountVO changeAccount(String accountID,String accountName);
	
	public boolean changeBalance(String accountName,String type,double amount);
	
	public BankAccountVO inquiryAccount(String accountID) throws RemoteException, IOException;
	
	public ArrayList<BankAccountVO> inquiryAccountByBank(String BankName);
	
	public ArrayList<BankAccountPO> getAllAccount();
}
