package elms.businesslogic.financebl;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;

import elms.businesslogic_service.financeblservice.BankAccountBlService;
import elms.dataservice.DataFactory;
import elms.dataservice.dealdataservice.DealDataService;
import elms.dataservice.financedataservice.FBankAccountDataService;
import elms.dataservice.financedataservice.FExpenseDataService;
import elms.dataservice.financedataservice.FIncomeDataService;
import elms.dataservice.financedataservice.FInitAllDataService;
import elms.dataservice.financedataservice.FStrategyDataService;
import elms.dataservice.userdataservice.UserDataService;
import elms.po.BankAccountPO;
import elms.vo.BankAccountVO;

public class BankAccountManager implements BankAccountBlService,DataFactory{

	FBankAccountDataService bankdata;
	public static ArrayList<BankAccountPO> bankaccountList = new ArrayList<BankAccountPO>();
	
	public static void main(String args[]) throws RemoteException{
		BankAccountManager bm = new BankAccountManager();
//		BankAccountVO vo1 = new BankAccountVO("ba00000001","zhang141250192", 0.0, "中国银行");
//		BankAccountVO vo2 = new BankAccountVO("ba00000002","张文玘", 0.0, "中国银行");
//		if(bm.addAccount(vo1))
//			bm.changeBalance( vo1.getAccountID(), "income", 200.0);
//		bm.changeBalance("ba00000001", "expense", 100.0);
//		bm.addAccount(vo2);
//		bm.show();
		
		
	}
	
	public BankAccountManager(){
		bankdata = getBankAccountData();
//		BankAccountVO vo1 = new BankAccountVO("ba00000001","zhang141250192", 0.0, "中国银行");
//		BankAccountVO vo2 = new BankAccountVO("ba00000002","张文玘", 0.0, "中国银行");
//		addAccount(vo1);
//		addAccount(vo2);
	}
	
	public void show(){
		for(int i = 0; i < bankaccountList.size(); i++){
			BankAccountPO po = bankaccountList.get(i);
			System.out.println("id:"+po.getAccountID()+" account name:"+po.getAccountName()+
					" balance:"+po.getAmount()+" bank:"+po.getBankName());
		}
	}
	
//	public boolean addAccount(BankAccountVO vo){
//		BankAccountPO po = new BankAccountPO(vo.getAccountID(),vo.getAccount(),vo.getAmount(),vo.getBankName());
//		if(bankaccountList.isEmpty()){
//			bankaccountList.add(po);
//			return true;
//		}
//		try {
//			if(inquiryAccount(vo.getAccountID())!=null){
//				String id = vo.getAccountID();
//				int temp = Integer.parseInt(id.substring(2, id.length()));
//				temp++;
//				id = ""+temp;
//				po.setAccountID(id);
//			}
//		} catch (IOException e) {
//			// TODO 自动生成的 catch 块
//			e.printStackTrace();
//		}
//		bankaccountList.add(po);
//		return true;
//	}

	public boolean addAccount(BankAccountVO vo){
		BankAccountPO accountpo = new BankAccountPO(vo.getAccountID(),vo.getAccount(),vo.getAmount(),
				vo.getBankName());
		try {
			if(inquiryAccount(vo.getAccountID())==null){
				System.out.println("there is no bankaccount in files,you can insert");
				try{
					bankdata.insert(accountpo);
					return true;
				}catch(Exception e){
					e.printStackTrace();
					System.out.println("insert failed!");
					return false;
				}
			}else{
				System.out.println("there is such a bankaccount in files,you need to change the name of it ");
				return false;
			}
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean deleteAccount(String accountID) {
//		try {
//			bankdata.delete(bankAccount);
//			return true;
//		} catch (RemoteException e) {
//			// TODO 自动生成的 catch 块
//			e.printStackTrace();
//			return false;
//		}
		for(int i = 0; i < bankaccountList.size(); i++){
			BankAccountPO po = bankaccountList.get(i);
			if(po.getAccountID().equals(accountID)){
				bankaccountList.remove(i);
				return true;
			}
		}
		return false;
		
	}

	public BankAccountVO changeAccount(String accountID, String accountName) {
		// TODO 自动生成的方法存根
		return null;
	}
	
	//这里的bankAccountPO参数是由于与服务器端连不起来，想要在本类内部进行测试所写的
	//以后连起来之后要删掉这个参数
	public boolean changeBalance(String accountID,String type, double amount){
		try {
//			BankAccountPO account = bankdata.find(accountName);
			BankAccountPO account = null;
			for(int i = 0; i < bankaccountList.size(); i++){
				if(bankaccountList.get(i).getAccountID().equals(accountID)){
					account = bankaccountList.get(i);
					break;
				}
			}
			if(account==null){
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
			System.out.println("after "+type+",balance:"+account.getAmount());
			show();
			return true;
		} catch (Exception e) {
			// TODO 自动生成的 catch 块

			e.printStackTrace();
			return false;
		}
		
		
	}

	public BankAccountVO inquiryAccount(String id) throws IOException {
		BankAccountPO po = bankdata.find(id);
		if(po==null){
			return null;
		}else{
		BankAccountVO vo = new BankAccountVO(po.getAccountID(),po.getAccountName(),po.getAmount(),
				po.getBankName());
		
		return vo;
		}
	}
//	public BankAccountVO inquiryAccount(String id) throws IOException {
//		for(int i = 0; i < bankaccountList.size(); i++){
//			BankAccountPO po = bankaccountList.get(i);
//			if(po.getAccountID().equals(id)){
//				BankAccountVO vo = new BankAccountVO(po.getAccountID(),po.getAccountName(),po.getAmount(),
//						po.getBankName());
//				return vo;
//			}
//		}
//		return null;
//	}

	public ArrayList<BankAccountVO> inquiryAccountByBank(String BankName) {
		// TODO 自动生成的方法存根
		return null;
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

	public FIncomeDataService getIncomeData(){
		
		return null;
	}

	public FExpenseDataService getExpenseData(){
	
		return null;
	}

	public FBankAccountDataService getBankAccountData(){
		DataFactory df;
		try{
			df=(DataFactory)Naming.lookup("rmi://localhost:1099/df");
			System.out.println("can't get datafactory? "+(df==null));
			System.out.println(df);
			return df.getBankAccountData();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("can't get bank account data service!");
			return null;
		}
	}

	public FStrategyDataService getFreightStrategyData() {
		
		return null;
	}

	public FInitAllDataService getInitData(){
		
		return null;
	}

	
}
