package elms.businesslogic_service.financeblservice;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import elms.vo.AccountVO;

public interface InitAllBlService {
public void init(String s) throws RemoteException, ClassNotFoundException, IOException;
public void copy() throws RemoteException, FileNotFoundException, ClassNotFoundException, IOException;
public void recovery()throws RemoteException, FileNotFoundException, ClassNotFoundException, IOException;
public boolean getInitState(int a) throws RemoteException;
public void setInitState();
public  void  addAccount(AccountVO vo);
public ArrayList<AccountVO> getAccount() throws ClassNotFoundException, IOException;
}
