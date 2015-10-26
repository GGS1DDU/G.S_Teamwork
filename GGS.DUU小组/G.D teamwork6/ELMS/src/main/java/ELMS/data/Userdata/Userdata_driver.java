package ELMS.data.Userdata;

import java.rmi.RemoteException;

import ELMS.dataservice.UserDataService;
import ELMS.po.UserPO;

public class Userdata_driver {
	public void drive(UserDataService UserDataService) throws RemoteException{
		//查找账户
		String id="zwh";
		UserPO po=null;	
		po=UserDataService.find(id);
		if(po!=null) System.out.println("查找到该账户!\n");
		
		//删除账户
		UserPO PO = new UserPO();
		UserDataService.delete(PO);
		System.out.println("成功删除账户!\n");
		
		//新增账户
		UserDataService.insert(PO);
		System.out.println("成功增加账户!\n");
		
		//更新账户
		UserDataService.update(PO);
		System.out.println("成功更新账户!\n");
		
		
		
			
	}

}
