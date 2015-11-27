package elms.businesslogic.logbl;



import java.rmi.RemoteException;

import elms.businesslogic_service.logblservice.LogBlService;
import elms.dataservice.DataFactory;
import elms.dataservice.dealdataservice.DealDataService;
import elms.dataservice.financedataservice.BankAccountDataService;
import elms.dataservice.financedataservice.ExpenseDataService;
import elms.dataservice.financedataservice.FreightStrategyDataService;
import elms.dataservice.financedataservice.IncomeDataService;
import elms.dataservice.financedataservice.InitAllDataService;
import elms.dataservice.logdataservice.LogDataService;
import elms.dataservice.storagedataservice.StorageDataService;
import elms.dataservice.userdataservice.UserDataService;
import elms.vo.LogVO;
public class Log implements LogBlService,DataFactory {

	public boolean buildLog(LogVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	public LogVO inquiry(String LogID) {
		// TODO Auto-generated method stub
		return null;
	}

	public LogList inquiryAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public UserDataService getUserData() {
		// TODO Auto-generated method stub
		return null;
	}

	public DealDataService getDealData() {
		// TODO Auto-generated method stub
		return null;
	}

	public LogDataService getLogData() {
		// TODO Auto-generated method stub
		return null;
	}

	public StorageDataService getStorageData() {
		// TODO Auto-generated method stub
		return null;
	}

	public IncomeDataService getIncomeData() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public ExpenseDataService getExpenseData() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public BankAccountDataService getBankAccountData() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public FreightStrategyDataService getFreightStrategyData()
			throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public InitAllDataService getInitData() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}
}
