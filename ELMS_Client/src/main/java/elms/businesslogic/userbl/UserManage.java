 package elms.businesslogic.userbl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import elms.businesslogic_service.userblservice.UserBlService;
import elms.dataservice.DataFactory;
import elms.dataservice.dealdataservice.DealDataService;
import elms.dataservice.financedataservice.BankAccountDataService;
import elms.dataservice.financedataservice.ExpenseDataService;
import elms.dataservice.financedataservice.IncomeDataService;
import elms.dataservice.financedataservice.InitAllDataService;
import elms.dataservice.invoicedataservice.ArrivalListDataService;
import elms.dataservice.invoicedataservice.IncomeListDataService;
import elms.dataservice.invoicedataservice.LoadingListDataService;
import elms.dataservice.invoicedataservice.LoadingListZZDataService;
import elms.dataservice.invoicedataservice.RecivalListDataService;
import elms.dataservice.invoicedataservice.SendingListDataService;
import elms.dataservice.invoicedataservice.TransferListDataService;
import elms.dataservice.managerdataservice.FreightStrategyDataService;
import elms.dataservice.managerdataservice.StaffDataService;
import elms.dataservice.memberdataservice.CarDataService;
import elms.dataservice.memberdataservice.DriverDataService;
import elms.dataservice.storagedataservice.StorageDataService;
import elms.dataservice.userdataservice.UserDataService;
import elms.po.UserPO;
import elms.vo.UserVO;

/**
 * 
 * @author ZWH
 *
 */

public class UserManage implements UserBlService ,DataFactory {
	
	UserDataService userdata;
	
	public UserManage(){
		userdata=getUserData();				
	}
	
	/**
	 * 根据账户和密码返回登录信息
	 * @param id
	 * @param password
	 */
	public int login(String id, String password) throws RemoteException {   
		if(userdata==null){
			return 999;
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
			
			if(po.getJob().equals("系统管理员")){
				return 1;
			
			}
			
			else if(po.getJob().equals("快递员")){
				return 2;
				
			}
			else if(po.getJob().equals("营业厅业务员")){
				return 3;
			
			}
			
			else if(po.getJob().equals("中转中心业务员")){
				return 4;
			
			}
			
			else if(po.getJob().equals("中转中心仓库管理人员")){
				return 5;
			
			}
			
			else if(po.getJob().equals("财务人员")){
				return 6;
			
			}
			
			else{      //是总经理
				return 7;
			
			}			
		}
		else{
			//密码错误
			return -1;
		}
		
		
	}
	
	/**
	 * 增加一个User
	 */
	public boolean addUser(UserVO uservo) throws IOException  {                //这个方法的返回值用布尔值不好...可以自己写个返回类型的类，因为有三种情况 ..
		UserPO userpo=new UserPO(uservo.getId(),uservo.getPassword(),uservo.getName(),uservo.getJob());
		
		ArrayList<UserPO> arr=null;      //试验代码，可删
		try { 
			if(findUser(uservo.getId())==null){
				try {
					userdata.insert(userpo);
					arr=userdata.findall();       //可删
					return true;
				} catch (Exception e) {
					e.printStackTrace();
					return false;
				}
			}
			else{
				return false;  //该账户已存在
			}
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		finally{
			for(int i=0;i<arr.size();i++){
				System.out.println("账号:"+arr.get(i).getId()+" 密码:"+arr.get(i).getPassword()+" 姓名："+arr.get(i).getName()+" 职务："+arr.get(i).getJob());
			}
		}  //finally可删
		
	
		
	
	}
	
	/**
	 * 更新一个账户的职务
	 */
	public boolean updateJob(String id, String password, String name,String job) throws RemoteException {		
		UserPO userpo=new UserPO(id,password,name,job);
		
		try {
			userdata.update(userpo);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	/**
	 * 删除User
	 */
	public boolean deleteUser(UserVO uservo) throws RemoteException {	
		UserPO userpo=new UserPO(uservo.getId(),uservo.getPassword(),uservo.getName(),uservo.getJob());
		try {
			userdata.delete(userpo);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		
	}
	/**
	 * 根据ID找到一个User
	 */
	public UserVO findUser(String id) throws IOException {
		UserPO userpo=userdata.find(id);
	
		if(userpo==null){ 
			return null;  //未找到该ID的账户。
		}
		else{
			UserVO vo=new UserVO(userpo.getId(),userpo.getPassword(),userpo.getName(),userpo.getJob());
			return vo;
		}
	}
	
	/**
	 * 返回所有的User
	 * 
	 */
	public ArrayList<UserVO> findall(){
		ArrayList<UserVO> arr=new ArrayList<UserVO>();
		ArrayList<UserPO> arr2=new ArrayList<UserPO>();
		try {
			arr2=userdata.findall();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		for(int i=0;i<arr2.size();i++){
			UserVO vo=new UserVO(arr2.get(i).getId(),arr2.get(i).getPassword(),arr2.get(i).getName(),arr2.get(i).getJob());
			arr.add(vo);
		}
		
		return arr;
		
		
	}

	
	
	public void endAccountOpt() {
		
	}


	public UserDataService getUserData() {
		DataFactory df;
		try{
			df=(DataFactory)Naming.lookup("rmi://localhost:1099/df");
			return df.getUserData();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}


	
	public DealDataService getDealData() {                
		return null;
	}


	public StorageDataService getStorageData() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public IncomeDataService getIncomeData() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ExpenseDataService getExpenseData() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public BankAccountDataService getBankAccountData() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public FreightStrategyDataService getFreightStrategyData()
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public InitAllDataService getInitData() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public StaffDataService getStaffData() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrivalListDataService getArrivalListData() {
		// TODO Auto-generated method stub
		return null;
	}

	public SendingListDataService getSendingListData() {
		// TODO Auto-generated method stub
		return null;
	}

	public IncomeListDataService getIncomeListData() {
		// TODO Auto-generated method stub
		return null;
	}

	public RecivalListDataService getRecivalListData() {
		// TODO Auto-generated method stub
		return null;
	}

	public LoadingListDataService getLoadingListData() {
		// TODO Auto-generated method stub
		return null;
	}

	public TransferListDataService getTransferListData() {
		// TODO Auto-generated method stub
		return null;
	}

	public LoadingListZZDataService getLoadingListZZData() {
		// TODO Auto-generated method stub
		return null;
	}

	public DriverDataService getDriverData() {
		// TODO Auto-generated method stub
		return null;
	}

	public CarDataService getCarData() {
		// TODO Auto-generated method stub
		return null;
	}







}

