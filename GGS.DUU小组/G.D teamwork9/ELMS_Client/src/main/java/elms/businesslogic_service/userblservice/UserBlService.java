package elms.businesslogic_service.userblservice;

import java.io.IOException;
import java.rmi.RemoteException;

import elms.vo.UserVO;

public interface UserBlService {
	public int login(String id, String password) throws RemoteException;
	
	
	public boolean updateJob(String id,String password,String name,String job) throws RemoteException;
	
	
	public boolean addUser(UserVO vo) throws RemoteException, IOException ;
	
	
	public boolean deleteUser(UserVO vo ) throws RemoteException ;
	
	
	public UserVO findUser(String id) throws RemoteException, IOException;
	
	
	public void endAccountOpt();
	

}
