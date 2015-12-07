package elms.businesslogic_service.financeblservice;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;



import elms.businesslogic.ResultMessage;
import elms.po.BankAccountPO;
import elms.vo.BankAccountVO;

public interface BankAccountBlService {
	public ResultMessage addAccount(BankAccountVO vo) throws RemoteException;
	
	public ResultMessage transferAccount(String id1,String id2,double amount) throws RemoteException, IOException;
	
	public ResultMessage deleteAccount(String bankAccount) throws RemoteException, IOException;
	
	public ResultMessage changeAccount(String accountID,String accountName) throws IOException;
	
	public ResultMessage changeBalance(String accountName,String type,double amount);
	
	public BankAccountVO inquiryAccount(String accountID) throws RemoteException, IOException;
	
	public ArrayList<BankAccountVO> inquiryAccountByBank(String BankName);
	
	public ArrayList<BankAccountVO> getAllAccount() throws RemoteException, IOException;
	
	public ResultMessage init() throws RemoteException, IOException;
	
}
