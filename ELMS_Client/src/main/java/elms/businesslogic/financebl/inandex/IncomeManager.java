package elms.businesslogic.financebl.inandex;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;

import elms.businesslogic.HallInfo;
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
	ArrayList<HallInfo> hallInfo = new ArrayList<HallInfo>();

	//收入项支出项id由用户输入

	public IncomeManager(){
		incomedata = getIncomeData();
		//测试用
		HallInfo info = new HallInfo("2015-12-17",123,"南京市鼓楼营业厅");
		HallInfo info1 = new HallInfo("2015-12-17",123,"南京市仙林营业厅");
		HallInfo info2 = new HallInfo("2015-12-18",123,"南京市鼓楼营业厅");
		HallInfo info3 = new HallInfo("2015-12-18",123,"南京市仙林营业厅");
		addHallInfo(info);
		addHallInfo(info1);
		addHallInfo(info2);
		addHallInfo(info3);
	}
	
	public void addHallInfo(HallInfo info){
		hallInfo.add(info);
	}
	
	public ArrayList<HallInfo> getHallInfo(){
		return hallInfo;
	}
	
	public ResultMessage addIncome(FIncomeVO vo) {
		//需要再写一个给对应账户增加余额的功能
		try {
//			if(inquiryIncome(vo.getID())!=null)
//				return ResultMessage.findIDFailed;   //findIDFailed代表已经存在这样的id，要求用户重新输入收入项id
			//id:时间+营业厅（8+2）
//			String[] t = vo.getTime().split("-");
//			String time = null;
//			for(int i = 0; i < t.length; i++){
//				time = time+t[i];
//			}
//			String hall = getHallId(vo.getShop());
//			if(hall!=null){  //若未能获取到对应营业厅的id？？
//			vo.setID(time+hall);
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
//			}
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

	public FIncomeVO inquiryIncome(String id){

		
		FIncomePO po = null;
		try {
			po = incomedata.find(id);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		System.out.println(po);
		if(po==null){
			return null;
		}else{
			FIncomeVO vo = new FIncomeVO(po.getBankAccountName(),po.getID(),po.getTime(),
					po.getIncome(),po.getShop(),po.getClerk());
			return vo;
		}
		
	}
	
	private ArrayList<FIncomeVO> getVOList(ArrayList<FIncomePO> arr){
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
			 {
		// TODO 自动生成的方法存根
		ArrayList<FIncomePO> arr;
		try {
			if(time1==null||time2==null){
				arr = incomedata.findAll();
			}else{
			arr = incomedata.findByTime(time1, time2);
			}
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
//		try {
			income = inquiryIncomeByTime(time1,time2);
//		} catch (RemoteException e) {
//			// TODO 自动生成的 catch 块
//			e.printStackTrace();
//		}
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

	public StorageDataService getStorageData() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}
	public StaffDataService getStaffData() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ArrivalListDataService getArrivalListData() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public SendingListDataService getSendingListData() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public IncomeListDataService getIncomeListData() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public RecivalListDataService getRecivalListData() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public LoadingListDataService getLoadingListData() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public TransferListDataService getTransferListData() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public LoadingListZZDataService getLoadingListZZData() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public DriverDataService getDriverData() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public CarDataService getCarData() {
		// TODO 自动生成的方法存根
		return null;
	}


}
