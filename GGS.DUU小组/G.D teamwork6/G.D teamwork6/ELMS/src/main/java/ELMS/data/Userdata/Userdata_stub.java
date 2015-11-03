package ELMS.data.Userdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import ELMS.dataservice.UserDataService;
import ELMS.po.UserPO;

public class Userdata_stub implements UserDataService{

	public UserPO find(String id) throws RemoteException {
		UserPO po=new UserPO();	
		return po;
	}

	public ArrayList<UserPO> findall() throws RemoteException {
		ArrayList<UserPO> arr=new ArrayList<UserPO>();
		UserPO po1=new UserPO();
		UserPO po2=new UserPO();
		arr.add(po1);
		arr.add(po2);
		return arr;		
	}

	public void insert(UserPO po) throws RemoteException {

		System.out.println("Insert Succeed！");
	}

	public void delete(UserPO po) throws RemoteException {
		System.out.println("delete Succeed！");
	}

	public void update(UserPO po) throws RemoteException {
		System.out.println("Update Succeed！");
	}

	public void init() throws RemoteException {

		
	}

	public void finish() throws RemoteException {
	
		
	}

}
