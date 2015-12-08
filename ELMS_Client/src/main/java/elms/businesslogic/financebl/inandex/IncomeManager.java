package elms.businesslogic.financebl.inandex;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;

import elms.businesslogic.ResultMessage;
import elms.businesslogic.financebl.BankAccountManager;
import elms.businesslogic_service.financeblservice.IncomeBlService;
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
import elms.dataservice.logdataservice.LogDataService;
import elms.dataservice.managerdataservice.FreightStrategyDataService;
import elms.dataservice.managerdataservice.StaffDataService;
import elms.dataservice.memberdataservice.CarDataService;
import elms.dataservice.memberdataservice.DriverDataService;
import elms.dataservice.storagedataservice.StorageDataService;
import elms.dataservice.userdataservice.UserDataService;
import elms.po.FIncomePO;
import elms.vo.FIncomeVO;

public class IncomeManager implements IncomeBlService,DataFactory{
	
	IncomeDataService incomedata;
	BankAccountManager bankmanage;

	//收入项支出项id由用户输入
	public static void main(String [] args) throws IOException{
		IncomeManager im = new IncomeManager();
		FIncomeVO vo = new FIncomeVO("ba00000002","in00000002","2015-01-01",0.0,
				"南京市仙林营业厅","张文玘");
//		boolean addSuccess = im.addIncome(new FIncomeVO("ba00000003","in00000008","2015-01-01",200.0,
//				"南京市鼓楼营业厅","张文玘"));
		System.out.println(im.addIncome(vo));
//		System.out.println(im.addIncome(vo));
//		System.out.println(im.deleteIncome(vo));
//		System.out.println(im.changeIncome(vo));
//		System.out.println(addSuccess);
//		im.deleteIncome(vo);
//		BankAccountManager bankmanage1 = new BankAccountManager();
//		System.out.println(bankmanage1.inquiryAccount("ba00000002").getAmount());

		FIncomeVO vo1 = im.inquiryIncome("in00000003");
		
//		ArrayList<FIncomeVO> arr = im.inquiryIncomeByHall("南京市仙林营业厅");
//		for(int i = 0; i < arr.size(); i++){
//			FIncomeVO vo1 = arr.get(i);
			System.out.println("in bank account id:"+vo1.getBankAccountName()+" income id:"+vo1.getID()+
					" income time:"+vo1.getTime()+" income amount:"+vo1.getIncome()+
					" income hall"+vo1.getShop()+" record person:"+vo1.getClerk());
//		}
	}
	public IncomeManager(){
		incomedata = getIncomeData();
	}
	
	
	
	public ResultMessage addIncome(FIncomeVO vo) {
		//需要再写一个给对应账户增加余额的功能
		try {
			if(inquiryIncome(vo.getID())!=null)
				return ResultMessage.findIDFailed;   //findIDFailed代表已经存在这样的id，要求用户重新输入收入项id
			FIncomePO po = new FIncomePO(vo.getBankAccountName(),vo.getID(),vo.getTime(),
						vo.getIncome(),vo.getShop(),vo.getClerk());	
		
			
			
			bankmanage = new BankAccountManager();
			ResultMessage rm = bankmanage.changeBalance(vo.getBankAccountName(), "income", vo.getIncome());

			if(rm==ResultMessage.findIDFailed)
				return ResultMessage.changeFailed;  //在这里的changeFailed代表的是找不到对应银行账户
			else if(rm==ResultMessage.lessThanMin)
				return ResultMessage.lessThanMin; //银行账户余额不足以支出
			else if(rm==ResultMessage.Failed)
				return ResultMessage.Failed; // io/remote错误
			else
			incomedata.insert(po);
			return ResultMessage.Success;
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return ResultMessage.Failed;
		} 
	}

	public ResultMessage deleteIncome(FIncomeVO vo) {
		FIncomePO po = new FIncomePO(vo.getBankAccountName(),vo.getID(),vo.getTime(),
				vo.getIncome(),vo.getShop(),vo.getClerk());
		
		try {
			if(inquiryIncome(vo.getID())==null)
				return ResultMessage.findIDFailed;
			incomedata.delete(po);
			
			bankmanage = new BankAccountManager();
			ResultMessage rm = bankmanage.changeBalance(vo.getBankAccountName(), "expense", vo.getIncome());
			
			
			if(rm==ResultMessage.findIDFailed)
				return ResultMessage.changeFailed;  //在这里的changeFailed代表的是找不到对应银行账户
			else if(rm==ResultMessage.lessThanMin)
				return ResultMessage.lessThanMin; //银行账户余额不足以支出
			else if(rm==ResultMessage.Failed)
				return ResultMessage.Failed; // io/remote错误
			else
				return ResultMessage.Success;
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return ResultMessage.Failed;
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return ResultMessage.Failed;
		}
		
		
	}

	public ResultMessage changeIncome(FIncomeVO vo) {
		FIncomePO po = new FIncomePO(vo.getBankAccountName(),vo.getID(),vo.getTime(),
				vo.getIncome(),vo.getShop(),vo.getClerk());
		try {
			FIncomeVO original = inquiryIncome(vo.getID());
			if(original==null){
				return ResultMessage.findIDFailed;
			}
			
			bankmanage  = new BankAccountManager();	
			double oldIncome = original.getIncome();
			ResultMessage rm = bankmanage.changeBalance(original.getBankAccountName(), "expense", oldIncome);
			if(rm==ResultMessage.findIDFailed)
				return ResultMessage.changeFailed;  //在这里的changeFailed代表的是找不到对应银行账户
			else if(rm==ResultMessage.lessThanMin)
				return ResultMessage.lessThanMin; //银行账户余额不足以支出
			else if(rm==ResultMessage.Failed)
				return ResultMessage.Failed; // io/remote错误
			
			ResultMessage rm1 = bankmanage.changeBalance(vo.getBankAccountName(), "income", vo.getIncome());
			if(rm==ResultMessage.findIDFailed)
				return ResultMessage.changeFailed;
			else if(rm==ResultMessage.Failed)
				return ResultMessage.Failed;    
			//不可能出现银行账户余额不足以支出的错误
			
			incomedata.update(po);
			return ResultMessage.Success;
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return ResultMessage.Failed;
	}

	public FIncomeVO inquiryIncome(String id) throws RemoteException, IOException {

		
		FIncomePO po = incomedata.find(id);
		System.out.println(po);
		if(po==null){
			return null;
		}else{
			FIncomeVO vo = new FIncomeVO(po.getBankAccountName(),po.getID(),po.getTime(),
					po.getIncome(),po.getShop(),po.getClerk());
			return vo;
		}
		
	}
	
	public ArrayList<FIncomeVO> getVOList(ArrayList<FIncomePO> arr){
		ArrayList<FIncomeVO> result = new ArrayList<FIncomeVO>();
		for(int i = 0; i < arr.size(); i++){
			FIncomePO po = arr.get(i);
			FIncomeVO vo = new FIncomeVO(po.getBankAccountName(),po.getID(),po.getTime(),
					po.getIncome(),po.getShop(),po.getClerk());
			result.add(vo);
		}
		return result;
	}

	public ArrayList<FIncomeVO> inquiryIncomeByHall(String center) {
		try {
			ArrayList<FIncomePO> arr = incomedata.findbyHall(center);
			ArrayList<FIncomeVO> res = getVOList(arr);
			return res;
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return null;
		} 
		
	}

	public ArrayList<FIncomeVO> inquiryIncomeByTime(String time1, String time2)
			throws RemoteException {
		// TODO 自动生成的方法存根
		ArrayList<FIncomePO> arr;
		try {
			arr = incomedata.findByTime(time1, time2);
			ArrayList<FIncomeVO> result = getVOList(arr);
			return result;
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return null;
		}
		
	
	}

	public ArrayList<FIncomeVO> inquiryInByTimeHall(String time1, String time2,
			String center) {
		// TODO 自动生成的方法存根
		ArrayList<FIncomePO> arr;
		try {
			arr = incomedata.findHallTime(time1, time2, center);
			ArrayList<FIncomeVO> result = getVOList(arr);
			return result;
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<FIncomeVO> inquiryAll(){
		try {
			ArrayList<FIncomePO> arr = incomedata.findAll();
			ArrayList<FIncomeVO> result = getVOList(arr);
			return result;
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return null;
		}
		
	}
	
	public double getTotalIn(String time1,String time2){
		ArrayList<FIncomeVO> income = new ArrayList<FIncomeVO>();
		double totalIn = 0.0;
		try {
			income = inquiryIncomeByTime(time1,time2);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		for(int i = 0; i < income.size(); i++){
			FIncomeVO vo = income.get(i);
			totalIn = vo.getIncome()+totalIn;
		}
		return totalIn;
	}
	
	public IncomeDataService getIncomeData(){
		DataFactory df;
		try{
			df = (DataFactory)Naming.lookup("rmi://localhost:1099/df");
			return df.getIncomeData();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("can't get income data from server!!!");
			return null;
		}
	}

	public UserDataService getUserData() {
		// TODO 自动生成的方法存根
		return null;
	}

	public DealDataService getDealData() {
		// TODO 自动生成的方法存根
		return null;
	}

	public ExpenseDataService getExpenseData() {
		// TODO 自动生成的方法存根
		return null;
	}

	public BankAccountDataService getBankAccountData() {
		// TODO 自动生成的方法存根
		return null;
	}

	public FreightStrategyDataService getFreightStrategyData(){
		// TODO 自动生成的方法存根
		return null;
	}

	public InitAllDataService getInitData() {
		// TODO 自动生成的方法存根
		return null;
	}
//	public LogDataService getLogData() throws RemoteException {
//		// TODO 自动生成的方法存根
//		return null;
//	}
//	public StorageDataService getStorageData() throws RemoteException {
//		// TODO 自动生成的方法存根
//		return null;
//	}
	public LogDataService getLogData() throws RemoteException {
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


}
