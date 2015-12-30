package elms.businesslogic.financebl;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;

import elms.businesslogic.ResultMessage;
import elms.businesslogic_service.financeblservice.BankAccountBlService;
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
import elms.po.BankAccountPO;
import elms.vo.BankAccountVO;

public class BankAccountManager implements BankAccountBlService,DataFactory{

	BankAccountDataService bankdata;

	
	public static void main(String args[]) throws IOException{
		BankAccountManager bm = new BankAccountManager();
		BankAccountVO vo1 = new BankAccountVO("ba00000001","zwq141250194", 0.0, "中国人民银行");

		
	}
	
	public BankAccountManager(){
		bankdata = getBankAccountData();

	}
	
	//转账，将账户1中amount数目的金额转至账户2中
	public ResultMessage transferAccount(String name1,String name2, double amount) throws IOException{
		
		BankAccountVO out = inquiryName(name1);
		if(out==null)
			return ResultMessage.findIDFailed;
		BankAccountVO in = inquiryName(name2);
		if(in==null)
			return ResultMessage.findIDFailed;
		
		System.out.println(out.getID());
		ResultMessage rm = changeBalance(out.getName(),"expense",amount);
//		System.out.println(rm);
		if(rm==ResultMessage.lessThanMin)
			return ResultMessage.lessThanMin;  //提示用户转出账户余额不足
		changeBalance(in.getName(),"income",amount);
		
		return ResultMessage.Success;
		
	}
	


	public ResultMessage addAccount(BankAccountVO vo){
		BankAccountPO accountpo = new BankAccountPO(vo.getID(),vo.getName(),vo.getAmount(),
				vo.getBank());
		try {
			if(bankdata.isEmpty()){
				bankdata.insert(accountpo);
				return ResultMessage.Success;
			}else if(!noSuchName(vo.getName())){
				return ResultMessage.findIDFailed; //已存在对应账户名，要求用户重新输入
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
			return ResultMessage.Success;
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return ResultMessage.Failed;
		}
		
	}
	


	public ResultMessage deleteAccount(String accountID) throws RemoteException, IOException {
		if(bankdata.isEmpty())
			return ResultMessage.lessThanMin;  //bankaccount列表为空，不可删除
		try {
			BankAccountVO vo = inquiryAccount(accountID);
			if(vo.getAmount()>0)
				return ResultMessage.changeFailed;//该银行账户余额不为0，在界面中显示一个警告信息
			if(bankdata.delete(accountID))
				return ResultMessage.Success;
			return ResultMessage.findIDFailed;//找不到对应账号     
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return ResultMessage.Failed;
		}
		
		
	}
	
	public ResultMessage init() throws RemoteException, IOException{
		ArrayList<BankAccountPO> bankaccount = bankdata.findAll();
//		BankAccountVO vo = new BankAccountVO("ba00000001","初始",0.0,"中国人民银行");
		if(bankaccount==null){
			return ResultMessage.Success;
		}
		
		for(int i = 0; i < bankaccount.size(); i++){
			BankAccountPO po = bankaccount.get(i);
			
			if(po.getAmount()>0)
				return ResultMessage.changeFailed;           //初始化删除原银行账户时该账户余额不为0，警告
		}
		 
		
		return ResultMessage.Success;
	}
	
	public ResultMessage initIgnoreAmount(){
		try {
			bankdata.init();
			return ResultMessage.Success;
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return ResultMessage.Failed;
		}
	}

	public ResultMessage changeAccount(String accountID, String accountName) throws IOException {
		BankAccountPO po = bankdata.find(accountID);
		if(po==null)
			return ResultMessage.findIDFailed;
		po.setName(accountName);
		try{
		if(bankdata.update(po))
			return ResultMessage.Success;
		return ResultMessage.Failed;
		}catch(Exception e){
			return ResultMessage.Failed;
		}
	}
	
	
	public ResultMessage changeBalance(String accountName,String type, double amount){
		try {
			BankAccountVO account = inquiryName(accountName);
			
			if(account==null){
				System.out.println("can't find account with Name "+accountName);
				return ResultMessage.findIDFailed;
			}
			double balance = account.getAmount();
			System.out.println("before "+type+",balance:"+balance);
			if(type.equals("income")){
				balance = balance+amount;
			}else{
				balance = balance - amount;
				if(balance<0)
					return ResultMessage.lessThanMin;
			}
			
			account.setAmount(balance);
			BankAccountPO po = new BankAccountPO(account.getID(),account.getName(),account.getAmount(),account.getBank());
			bankdata.update(po);
			System.out.println("after "+type+",balance:"+account.getAmount());
			
			return ResultMessage.Success;
		} catch (Exception e) {
			// TODO 自动生成的 catch 块

			e.printStackTrace();
			return ResultMessage.Failed;
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

	public String[] getNameList(){
		ArrayList<BankAccountVO> accountList = new ArrayList<BankAccountVO>();

		accountList = getAllAccount();
		
		
		String[] nameList = new String[accountList.size()];
		for(int i = 0; i < accountList.size(); i++){
			nameList[i] = accountList.get(i).getName();
		}
		return nameList;
	}
	public ArrayList<BankAccountVO> getAllAccount() {
		// TODO 自动生成的方法存根
		ArrayList<BankAccountPO> poList = new ArrayList<BankAccountPO>();
		
			try {
				poList = bankdata.findAll();
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} 
		
		ArrayList<BankAccountVO> voList = new ArrayList<BankAccountVO>();
		for(int i = 0; i < poList.size(); i++){
			BankAccountPO po = poList.get(i);
			BankAccountVO vo = new BankAccountVO(po.getID(),po.getName(),po.getAmount(),po.getBank());
			voList.add(vo);
		}
		return voList;
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



	public StorageDataService getStorageData() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public StaffDataService getStaffData() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public ArrivalListDataService getArrivalListData() {
		// TODO 自动生成的方法存根
		return null;
	}

	public SendingListDataService getSendingListData() {
		// TODO 自动生成的方法存根
		return null;
	}

 
	public IncomeListDataService getIncomeListData() {
		// TODO 自动生成的方法存根
		return null;
	}

	public RecivalListDataService getRecivalListData() {
		// TODO 自动生成的方法存根
		return null;
	}

	public LoadingListDataService getLoadingListData() {
		// TODO 自动生成的方法存根
		return null;
	}

	public TransferListDataService getTransferListData() {
		// TODO 自动生成的方法存根
		return null;
	}

	public LoadingListZZDataService getLoadingListZZData() {
		// TODO 自动生成的方法存根
		return null;
	}

	public DriverDataService getDriverData() {
		// TODO 自动生成的方法存根
		return null;
	}

	public CarDataService getCarData() {
		// TODO 自动生成的方法存根
		return null;
	}

	



//	public LogDataService getLogData() throws RemoteException {
//		// TODO 自动生成的方法存根
//		return null;
//	}
//
//	public StorageDataService getStorageData() throws RemoteException {
//		// TODO 自动生成的方法存根
//		return null;
//	}



	
}
