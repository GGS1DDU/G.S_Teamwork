package elms.businesslogic.financebl;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;

import elms.businesslogic_service.financeblservice.IncomeBlService;
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
import elms.po.FIncomePO;
import elms.vo.FIncomeVO;

public class IncomeManager implements IncomeBlService,DataFactory{
	
	IncomeDataService incomedata;
	BankAccountManager bankmanage;

	//注意从界面层调用时，收入项id普遍传入in00000001为初始值，最后存储的id为自动生成的
	public static void main(String [] args) throws IOException{
		IncomeManager im = new IncomeManager();
		FIncomeVO vo = new FIncomeVO("ba00000002","in00000005","2015-01-01",200.0,
				"南京市仙林营业厅","张文玘");
//		boolean addSuccess = im.addIncome(new FIncomeVO("ba00000003","in00000008","2015-01-01",200.0,
//				"南京市鼓楼营业厅","张文玘"));
		im.addIncome(vo);
//		System.out.println(addSuccess);
//		im.deleteIncome(vo);
//		BankAccountManager bankmanage1 = new BankAccountManager();
//		System.out.println(bankmanage1.inquiryAccount("ba00000002").getAmount());

		ArrayList<FIncomeVO> arr = im.inquiryIncomeByHall("南京市仙林营业厅");
		for(int i = 0; i < arr.size(); i++){
			FIncomeVO vo1 = arr.get(i);
			System.out.println("in bank account id:"+vo1.getBankAccountName()+" income id:"+vo1.getID()+
					" income time:"+vo1.getTime()+" income amount:"+vo1.getIncome()+
					" income hall"+vo1.getShop()+" record person:"+vo1.getClerk());
		}
	}
	public IncomeManager(){
		incomedata = getIncomeData();
	}
	
	
	
	public boolean addIncome(FIncomeVO vo) {
		//需要再写一个给对应账户增加余额的功能
		try {
			if(inquiryIncome(vo.getID())!=null)
				return false;
			FIncomePO po = new FIncomePO(vo.getBankAccountName(),vo.getID(),vo.getTime(),
						vo.getIncome(),vo.getShop(),vo.getClerk());	
		
			
			
			bankmanage = new BankAccountManager();
			boolean changeSuccess = bankmanage.changeBalance(vo.getBankAccountName(), "income", vo.getIncome());

			if(!changeSuccess){
				System.out.println("add income to bank account! failed!");
				return false;
			}
			incomedata.insert(po);
			return true;
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return false;
		} 
	}

	public boolean deleteIncome(FIncomeVO vo) {
		FIncomePO po = new FIncomePO(vo.getBankAccountName(),vo.getID(),vo.getTime(),
				vo.getIncome(),vo.getShop(),vo.getClerk());
		bankmanage = new BankAccountManager();
		bankmanage.changeBalance(vo.getBankAccountName(), "expense", vo.getIncome());
		try {
			incomedata.delete(po);
			return true;
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return false;
		}
		
		
	}

	public boolean changeIncome(FIncomeVO vo) {
		FIncomePO po = new FIncomePO(vo.getBankAccountName(),vo.getID(),vo.getTime(),
				vo.getIncome(),vo.getShop(),vo.getClerk());
		try {
			incomedata.update(po);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return false;
	}

	public FIncomeVO inquiryIncome(String id) throws RemoteException, IOException {

		
		FIncomePO po = incomedata.find(id);

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
	public LogDataService getLogData() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}
	public StorageDataService getStorageData() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

}
