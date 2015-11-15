 package elms.businesslogic.userbl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import elms.businesslogic_service.userblservice.UserBlService;
import elms.dataservice.DataFactory;
import elms.dataservice.dealdataservice.DealDataService;
import elms.dataservice.userdataservice.UserDataService;
import elms.po.UserPO;
import elms.vo.UserVO;



public class UserBL implements UserBlService ,DataFactory {
	
	UserVO vo;
	
	public int login(String id, String password) throws RemoteException {
		UserBL U=new UserBL();
		UserDataService userdata=U.getUserData();
		if(id.equals("")){
			//是寄件人
			return 0;
		}
		UserPO po = null;
		
			try {
				po=userdata.find(id);
			} catch (IOException e) {
				e.printStackTrace();
			}	
		if(po==null){
			//未找到该账户
			return -2;
		}
		if(po.getPassword().equals(password)){
			//密码正确，开始区分是什么职务
			if(po.getJob().equals("快递员")){
				return 2;
				
			}
			if(po.getJob().equals("系统管理员")){
				return 1;
			
		}}
		else{
			//密码错误
			return -1;
		}
			return -1;
		
		
	}
	

	public boolean addUser(String id, String password, String name, String job) throws IOException  {
		UserBL ub=new UserBL();
		UserDataService userdata=ub.getUserData();
		UserPO po=new UserPO(id,password,name,job);
		try {
			if(ub.findUser(id)==null){
				try {
					userdata.insert(po);
					return true;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
		
	
	}

	public boolean updateJob(String id, String password, String name,String job) throws RemoteException {
		UserBL ub=new UserBL();
		UserDataService userdata=ub.getUserData();
		
		UserPO po=new UserPO(id,password,name,job);
		try {
			System.out.println(id+password+name+job+"1");
			userdata.update(po);
			System.out.println(id+password+name+job+"2");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean deleteUser(String id, String password, String name,String job) throws RemoteException {
		UserBL ub=new UserBL();
		UserDataService userdata=ub.getUserData();
		
		UserPO po=new UserPO(id,password,name,job);
		try {
			userdata.delete(po);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		
	}

	public UserVO findUser(String id) throws IOException {
		
		UserBL ub=new UserBL();
		UserDataService userdata=ub.getUserData();
		UserPO po=userdata.find(id);

		
		if(po==null){
			return null;
		}
		else{
			UserVO vo=new UserVO(po.getId(),po.getPassword(),po.getName(),po.getJob());
			return vo;
		}
	}

	
	
	public void endAccountOpt() {
		// TODO Auto-generated method stub
		
	}


	public UserDataService getUserData() {
		DataFactory df;
		UserDataService userdata=null;
		try{
			df=(DataFactory)Naming.lookup("rmi://localhost:1099/df");
			userdata=df.getUserData();
		}catch(Exception e){
			e.printStackTrace();
		}
		return userdata;
	}


	
	public DealDataService getDealData() {
		// TODO Auto-generated method stub
		return null;
	}







}

