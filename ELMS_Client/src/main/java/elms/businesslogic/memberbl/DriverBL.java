package elms.businesslogic.memberbl;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;

import elms.businesslogic_service.memberblservice.DriverBLService;
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
//import elms.dataservice.logdataservice.LogDataService;
import elms.dataservice.managerdataservice.FreightStrategyDataService;
import elms.dataservice.managerdataservice.StaffDataService;
import elms.dataservice.memberdataservice.CarDataService;
import elms.dataservice.memberdataservice.DriverDataService;
import elms.dataservice.storagedataservice.StorageDataService;
import elms.dataservice.userdataservice.UserDataService;
import elms.po.DriverPO;
import elms.vo.DriverVO;

public class DriverBL implements DriverBLService,DataFactory{
	DriverDataService driverdata;
	
	public DriverBL(){
		driverdata=getDriverData();
	}

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
		// TODO 自动生成的方法存根
		return null;
	}

	public DriverDataService getDriverData() {
		DataFactory df;
		try{
			df=(DataFactory)Naming.lookup("rmi://localhost:1099/df");
		return df.getDriverData();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	public DriverVO inquiry(String id) throws IOException {
		DriverPO po=driverdata.find(id);
		if(po!=null){
			DriverVO vo=new DriverVO(po.getID(),po.getName(),po.getBirthday(),po.getIDcard(),po.getCallNumber(),po.getGender(),po.getLicenseDate());
            return vo;
		}else
			return null;
	}

	public DriverVO record(DriverVO vo) throws IOException {
		DriverPO po=new DriverPO(vo.getID(),vo.getName(),vo.getBirthday(),vo.getIDcard(),vo.getCallNumber(),vo.getGender(),vo.getLicenseDate());
		driverdata.insert(po);
		return vo;
	}

	public void init() throws IOException {
		driverdata.init();
		
	}

	public void delete(DriverVO vo) throws IOException {
		DriverPO po=driverdata.find(vo.getID());
		driverdata.delete(po);
		
	}

	public void endOpt() throws IOException {
		// TODO 自动生成的方法存根
		
	}

	public CarDataService getCarData() {
		// TODO 自动生成的方法存根
		return null;
	}

	public ArrayList<DriverVO> inquiryAll() throws IOException {
		// TODO 自动生成的方法存根
		ArrayList<DriverVO> voarr=new ArrayList<DriverVO>();
		ArrayList<DriverPO> poarr=new ArrayList<DriverPO>();
		poarr=driverdata.findall();
		if(poarr.size()>0){
		for(DriverPO po:poarr){
			DriverVO vo=new DriverVO(po.getID(),po.getName(),po.getBirthday(),po.getIDcard(),
					po.getCallNumber(),po.getGender(),po.getLicenseDate());
			voarr.add(vo);
		}}
		return voarr;
	}

//	public LogDataService getLogData() throws RemoteException {
//		// TODO 自动生成的方法存根
//		return null;
//	}

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
