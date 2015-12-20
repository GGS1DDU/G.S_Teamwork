package elms.businesslogic.financebl;

import java.rmi.Naming;
import java.rmi.RemoteException;

import elms.businesslogic_service.financeblservice.FreightStrategyBlService;
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
import elms.po.FreightStrategyPO;
import elms.vo.FreightStrategyVO;

public class FreightStrategyManager implements FreightStrategyBlService,DataFactory{

	FreightStrategyDataService fsds;
	
	public static void main(String[] args){
		FreightStrategyManager fsm = new FreightStrategyManager();
	}

	public FreightStrategyManager(){
		fsds = getFreightStrategyData();
	}
	
	public boolean initFreight() {
		// TODO 自动生成的方法存根
		//这里应该直接调用数据层的init方法

		return false;
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

	public IncomeDataService getIncomeData() {
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

	public FreightStrategyDataService getFreightStrategyData() {
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
