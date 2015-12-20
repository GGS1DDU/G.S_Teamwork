package elms.businesslogic.invoicebl;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.RemoteException;

import elms.businesslogic_service.invoiceblservice.LoadingListZZBLService;
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
import elms.po.LoadingListZZPO;
import elms.vo.LoadingListZZVO;

public class LoadingListZZBL implements LoadingListZZBLService,DataFactory{
	LoadingListZZDataService loadinglistzzdata;
	
	public UserDataService getUserData() {
		// TODO 自动生成的方法存根
		return null;
	}

	public DealDataService getDealData() {
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
		DataFactory df;
		try{
			df=(DataFactory)Naming.lookup("rmi://192.168.191.1:1099/df");
		return df.getLoadingListZZData();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	public LoadingListZZVO inquiry(String id) throws IOException {
		LoadingListZZPO po=loadinglistzzdata.find(id);
		if(po!=null){
			LoadingListZZVO vo=new LoadingListZZVO(po.getID(),po.getTime(),po.getTransportNumber(),po.getArrival(),po.getCarNumber(),po.getSurpervior(),po.getSupercargo(),po.getOrderNumber(),po.getCost());
			return vo;
		}else
		return null;	}

	public LoadingListZZVO record(LoadingListZZVO vo) throws IOException {
		LoadingListZZPO po=new LoadingListZZPO(vo.getID(),vo.getTime(),vo.getTransportNumber(),vo.getArrival(),vo.getCarNumber(),vo.getSurpervior(),vo.getSupercargo(),vo.getOrderNumber(),vo.getCost());
		loadinglistzzdata.insert(po);
		return vo;
	}

	public void init() throws IOException {
		loadinglistzzdata.init();
		
	}

	public void delete(LoadingListZZVO vo) throws IOException {
		LoadingListZZPO po=loadinglistzzdata.find(vo.getID());
		loadinglistzzdata.delete(po);	
	}

	public boolean Approval(String id) throws IOException {
		// TODO 自动生成的方法存根
		return false;
	}

	public void endOpt() throws IOException {
		// TODO 自动生成的方法存根
		
	}

	public DriverDataService getDriverData() {
		// TODO 自动生成的方法存根
		return null;
	}

	public CarDataService getCarData() {
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

	public StaffDataService getStaffData() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

}
