package elms.businesslogic.financebl;

import java.rmi.Naming;

import elms.businesslogic_service.financeblservice.FreightStrategyBlService;
import elms.dataservice.DataFactory;
import elms.dataservice.dealdataservice.DealDataService;
import elms.dataservice.financedataservice.FBankAccountDataService;
import elms.dataservice.financedataservice.FExpenseDataService;
import elms.dataservice.financedataservice.FIncomeDataService;
import elms.dataservice.financedataservice.FInitAllDataService;
import elms.dataservice.financedataservice.FStrategyDataService;
import elms.dataservice.userdataservice.UserDataService;
import elms.po.FreightStrategyPO;
import elms.vo.FreightStrategyVO;

public class FreightStrategyManager implements FreightStrategyBlService,DataFactory{

	FStrategyDataService fsds;
	
	public static void main(String[] args){
		FreightStrategyManager fsm = new FreightStrategyManager();
	}

	public FreightStrategyManager(){
//		fsds = getFreightStrategyData();
	}
	
	public boolean initFreight() {
		// TODO 自动生成的方法存根
		//这里应该直接调用数据层的init方法
		FreightStrategyPO po = new FreightStrategyPO(null,"南京","上海",200.0, 15.4,13.9, 
				18.2, 1000);
		return true;
	}

	public FreightStrategyPO getFreightStrategy() {
		// TODO 自动生成的方法存根
		return null;
	}

	public FreightStrategyVO setFreight(FreightStrategyVO vo) {
		// TODO 自动生成的方法存根
		
		return null;
	}
	
	
	

	public UserDataService getUserData() {
		// TODO 自动生成的方法存根
		return null;
	}

	public DealDataService getDealData() {
		// TODO 自动生成的方法存根
		return null;
	}

	public FIncomeDataService getIncomeData() {
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

	public FStrategyDataService getFreightStrategyData() {
		// TODO 自动生成的方法存根
		DataFactory df;
		try{
			df = (DataFactory) Naming.lookup("rmi://localhost:1099/df");
			return df.getFreightStrategyData();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("can't connect to server");
			return null;
		}
		
	}

	public FInitAllDataService getInitData() {
		// TODO 自动生成的方法存根
		return null;
	}
}
