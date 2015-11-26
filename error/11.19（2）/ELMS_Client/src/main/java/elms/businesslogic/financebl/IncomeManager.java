package elms.businesslogic.financebl;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;

import elms.businesslogic_service.financeblservice.IncomeBlService;
import elms.dataservice.DataFactory;
import elms.dataservice.dealdataservice.DealDataService;
import elms.dataservice.financedataservice.FBankAccountDataService;
import elms.dataservice.financedataservice.FExpenseDataService;
import elms.dataservice.financedataservice.FIncomeDataService;
import elms.dataservice.financedataservice.FInitAllDataService;
import elms.dataservice.financedataservice.FStrategyDataService;
import elms.dataservice.userdataservice.UserDataService;
import elms.po.FIncomePO;
import elms.vo.FIncomeVO;

public class IncomeManager implements IncomeBlService,DataFactory{
	
	FIncomeDataService incomedata;
	BankAccountManager bankmanage;
	
	public static ArrayList<FIncomePO> incomeList = new ArrayList<FIncomePO>();

	//注意从界面层调用时，收入项id普遍传入in00000001为初始值，最后存储的id为自动生成的
	public static void main(String [] args){
		IncomeManager im = new IncomeManager();
		boolean addSuccess = im.addIncome(new FIncomeVO("ba00000001","in00000001","2015-01-01",200.0,
				"南京市鼓楼营业厅","张文玘"));
		im.addIncome(new FIncomeVO("ba00000001","in00000001","2015-01-01",300.0,
				"南京市鼓楼营业厅","张文玘"));
	}
	public IncomeManager(){
//		incomedata = getIncomeData();
	}
	
	
	public void show(){
		for(int i = 0; i < incomeList.size(); i++){
			FIncomePO po = incomeList.get(i);
			System.out.println("bank account: "+po.getBankAccountName()+" income id: "+po.getID()+
					" income amount: "+po.getIncome());
		}
	}
	
	public boolean addIncome(FIncomeVO vo) {
		//需要再写一个给对应账户增加余额的功能
		
		
		
		try {
			
			
			if(incomeList.isEmpty()){
				FIncomePO po = new FIncomePO(vo.getBankAccountName(),vo.getID(),vo.getTime(),
						vo.getIncome(),vo.getShop(),vo.getClerk());	
			}else{
				
				
			do{
				String id = vo.getID();
				String num = id.substring(2, 10);
				int i = Integer.parseInt(num);
				i++;
				String xs = String.valueOf(i);
				String[] ss = {"0000000","000000","00000","0000","000","00","0"};
				id = ss[xs.length()-1]+xs;
				vo.setID("in"+id);
				System.out.println(vo.getID());
			}while(inquiryIncome(vo.getID())!=null);  //自动生成收入项id，遍历增加
			
			
			
			}
			
			
			FIncomePO po = new FIncomePO(vo.getBankAccountName(),vo.getID(),vo.getTime(),
					vo.getIncome(),vo.getShop(),vo.getClerk());
//	!!!		incomedata.insert(po);
			
			incomeList.add(po);
			
			show();
			
			bankmanage = new BankAccountManager();
			boolean changeSuccess = bankmanage.changeBalance(vo.getBankAccountName(), "income", vo.getIncome());
//	!!		boolean changeSuccess = bankmanage.changeBalance(vo.getBankAccountName(), "income", vo.getIncome());
			if(!changeSuccess){
				System.out.println("add income to bank account! failed!");
				return false;
			}
			return true;
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return false;
		} 
	}

	public boolean deleteIncome(FIncomeVO vo) {
		// TODO 自动生成的方法存根
		return false;
	}

	public boolean changeIncome(FIncomeVO vo) {
		// TODO 自动生成的方法存根
		return false;
	}

	public FIncomeVO inquiryIncome(String id) throws RemoteException, IOException {
//		FIncomePO po = incomedata.find(id);
		
		FIncomePO po = null;
		for(int i = 0; i < incomeList.size(); i++){
			if(incomeList.get(i).getID().equals(id)){
				po = incomeList.get(i);
				break;
			}
		}
		if(po==null){
			return null;
		}else{
			FIncomeVO vo = new FIncomeVO(po.getBankAccountName(),po.getID(),po.getTime(),
					po.getIncome(),po.getShop(),po.getClerk());
			return vo;
		}
		
	}

	public ArrayList<FIncomeVO> inquiryIncomeByHall(String center) {
		// TODO 自动生成的方法存根
		return null;
	}

	public ArrayList<FIncomeVO> inquiryIncomeByTime(String time1, String time2)
			throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public ArrayList<FIncomeVO> inquiryInByTimeHall(String time1, String time2,
			String center) {
		// TODO 自动生成的方法存根
		return null;
	}
	
	public FIncomeDataService getIncomeData(){
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

	public FExpenseDataService getExpenseData() {
		// TODO 自动生成的方法存根
		return null;
	}

	public FBankAccountDataService getBankAccountData() {
		// TODO 自动生成的方法存根
		return null;
	}

	public FStrategyDataService getFreightStrategyData(){
		// TODO 自动生成的方法存根
		return null;
	}

	public FInitAllDataService getInitData() {
		// TODO 自动生成的方法存根
		return null;
	}

}
