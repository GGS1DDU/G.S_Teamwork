package elms.businesslogic.financebl;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;

import elms.businesslogic_service.financeblservice.BankAccountBlService;
import elms.dataservice.DataFactory;
import elms.dataservice.dealdataservice.DealDataService;
import elms.dataservice.financedataservice.BankAccountDataService;
import elms.dataservice.financedataservice.ExpenseDataService;
import elms.dataservice.financedataservice.IncomeDataService;
import elms.dataservice.financedataservice.InitAllDataService;
import elms.dataservice.financedataservice.FreightStrategyDataService;
import elms.dataservice.logdataservice.LogDataService;
import elms.dataservice.storagedataservice.StorageDataService;
import elms.dataservice.userdataservice.UserDataService;
import elms.po.BankAccountPO;
import elms.vo.BankAccountVO;

public class BankAccountManager implements BankAccountBlService,DataFactory{

	BankAccountDataService bankdata;

	
	public static void main(String args[]) throws IOException{
		BankAccountManager bm = new BankAccountManager();
//		BankAccountVO vo1 = new BankAccountVO("ba00000001","zwq141250194", 0.0, "中国人民银行");
//		boolean addSuccess = bm.addAccount(vo1);
//		System.out.println(addSuccess);
//		boolean changeSuccess = bm.changeBalance("ba00000003", "income", 200.0);
//		System.out.println(changeSuccess);
//		BankAccountVO find = bm.inquiryAccount("ba00000003");
//		System.out.println(find.getAmount());
//		BankAccountVO vo2 = new BankAccountVO("ba00000002","张文玘", 0.0, "中国银行");
//		if(bm.addAccount(vo1))
//			bm.changeBalance( vo1.getAccountID(), "income", 200.0);
//		bm.changeBalance("ba00000001", "expense", 100.0);
//		bm.addAccount(vo2);
//		bm.show();
//		bm.deleteAccount("ba00000001");
		ArrayList<BankAccountVO> arr = bm.inquiryAccountByBank("中国人民银行");
		for(int i = 0; i < arr.size();i ++){
			System.out.println("account id:"+arr.get(i).getID()+" account name:"+arr.get(i).getName()+
					" account balance:"+arr.get(i).getAmount()+" bank name:"+arr.get(i).getBank());
		}
//		
		
	}
	
	public BankAccountManager(){
		bankdata = getBankAccountData();

	}
	
	
	


	public boolean addAccount(BankAccountVO vo){
		BankAccountPO accountpo = new BankAccountPO(vo.getID(),vo.getName(),vo.getAmount(),
				vo.getBank());
		try {
			if(bankdata.isEmpty()){
				bankdata.insert(accountpo);
				return true;
			}else if(!noSuchName(vo.getName())){
				return false;
			}
			do{
				String id = vo.getID();
				String num = id.substring(2, 10);
				int i = Integer.parseInt(num);
				i++;
				String xs = String.valueOf(i);
				String[] ss = {"0000000","000000","00000","0000","000","00","0"};
				id = ss[xs.length()-1]+xs;
				vo.setID("ba"+id);
				
			}while(inquiryAccount(vo.getID())!=null);  //自动生成收入项id，遍历增加
			
			System.out.println(vo.getID());
			accountpo.setID(vo.getID());
			bankdata.insert(accountpo);
			return true;
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean deleteAccount(String accountID) {
		try {
			if(bankdata.delete(accountID))
				return true;
			return false;
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return false;
		}
		
		
	}

	public boolean changeAccount(String accountID, String accountName) throws IOException {
		BankAccountPO po = bankdata.find(accountID);
		if(po==null)
			return false;
		po.setName(accountName);
		try{
		if(bankdata.update(po))
			return true;
		return false;
		}catch(Exception e){
			return false;
		}
	}
	
	
	public boolean changeBalance(String accountID,String type, double amount){
		try {
			BankAccountPO account = bankdata.find(accountID);
			
			if(account==null){
				System.out.println("can't find account with ID "+accountID);
				return false;
			}
			double balance = account.getAmount();
			System.out.println("before "+type+",balance:"+balance);
			if(type.equals("income")){
				balance = balance+amount;
			}else{
				balance = balance - amount;
			}
			
			account.setAmount(balance);
			bankdata.update(account);
			System.out.println("after "+type+",balance:"+account.getAmount());
			
			return true;
		} catch (Exception e) {
			// TODO 自动生成的 catch 块

			e.printStackTrace();
			return false;
		}
		
		
	}
	
	//这个方法不好，findAll这个data接口就不好
	public BankAccountVO inquiryName(String accountName) throws RemoteException, IOException{
		ArrayList<BankAccountPO> PoArr = bankdata.findAll();
		ArrayList<BankAccountVO> VoArr = getVOList(PoArr);
		int i = 0;
		boolean find  = false;
		for(; i < VoArr.size(); i++){
			
			if(VoArr.get(i).getName().equals(accountName)){
				find  = true;
				break;
			}
		}
		if(!find)
			return null;
		else
			return VoArr.get(i);
	}

	public BankAccountVO inquiryAccount(String id) throws IOException {
		BankAccountPO po = bankdata.find(id);
		if(po==null){
			System.out.println("can't find account "+id);
			return null;
		}else{
		BankAccountVO vo = new BankAccountVO(po.getID(),po.getName(),po.getAmount(),
				po.getBank());
		
		return vo;
		}
	}
	
	public ArrayList<BankAccountVO> getVOList(ArrayList<BankAccountPO> accountList){
		ArrayList<BankAccountVO> result = new ArrayList<BankAccountVO>();
		for(int i = 0; i < accountList.size(); i++){
			BankAccountPO po = accountList.get(i);
			BankAccountVO vo = new BankAccountVO(po.getID(),po.getName(),po.getAmount(),po.getBank());
			result.add(vo);
			
		}
		return result;
		
	}
	
	public boolean noSuchName(String accountName) throws IOException{
		ArrayList<BankAccountPO> accountList = bankdata.findAll();
		for(int i = 0; i < accountList.size(); i++){
			BankAccountPO po = accountList.get(i);
			System.out.println(po.getName());
			if(accountList.get(i).getName().equals(accountName)){
				return false;
			}
		}
		return true;
	}


	public ArrayList<BankAccountVO> inquiryAccountByBank(String BankName) {
		ArrayList<BankAccountPO> accountList;
		try {
			accountList = bankdata.findByBank(BankName);
		} catch(Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return null;
		} 
		ArrayList<BankAccountVO> result = getVOList(accountList);
		
		
		return result;
	}

	public ArrayList<BankAccountPO> getAllAccount() {
		// TODO 自动生成的方法存根
		return null;
	}
	
	

	public UserDataService getUserData() {
		
		return null;
	}

	public DealDataService getDealData() {
		
		return null;
	}



	public BankAccountDataService getBankAccountData(){
		DataFactory df;
		try{
			df=(DataFactory)Naming.lookup("rmi://localhost:1099/df");
			
			return df.getBankAccountData();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	public IncomeDataService getIncomeData() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public ExpenseDataService getExpenseData() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}



	public FreightStrategyDataService getFreightStrategyData() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public InitAllDataService getInitData() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public LogDataService getLogData() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public StorageDataService getStorageData() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}



	
}
