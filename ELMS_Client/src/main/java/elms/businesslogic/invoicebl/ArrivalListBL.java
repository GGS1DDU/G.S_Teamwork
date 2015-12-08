package elms.businesslogic.invoicebl;

import java.io.IOException;
import java.rmi.Naming;
//import java.util.ArrayList;


import java.rmi.RemoteException;

import elms.businesslogic_service.invoiceblservice.ArrivalListBLService;
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
import elms.po.ArrivalListPO;
import elms.vo.ArrivalListVO;

public class ArrivalListBL implements ArrivalListBLService,DataFactory{
	ArrivalListDataService arrivallistdata;
	
	public ArrivalListBL(){
		arrivallistdata=getArrivalListData();
	}

//	public static void main(String args[]) throws IOException{
//		ArrivalListBL a=new ArrivalListBL();
//		ArrayList<ArrivalListVO> arr=new ArrayList<ArrivalListVO>();
//		ArrivalListVO vo=new ArrivalListVO("al00001","025000201511190000001","2015-11-19","完整","北京");
//		ArrivalListVO vo1=new ArrivalListVO("al00002","025000201511200000002","2015-11-20","损坏","上海");
//        ArrivalListVO vo2=new ArrivalListVO("al00003","025000201511210000003","2015-11-21","丢失","广州");
//        arr.add(vo);
//        arr.add(vo1);
//        arr.add(vo2);
//        
//        a.inquiry("al00001");
//	} 
	
	public UserDataService getUserData() {
		// TODO 自动生成的方法存根
		return null;
	}

	public DealDataService getDealData() {
		// TODO 自动生成的方法存根
		return null;
	}

	public ArrivalListVO inquiry(String id) throws IOException {
		ArrivalListPO po=arrivallistdata.find(id);
		if(po!=null){
			ArrivalListVO vo=new ArrivalListVO(po.getID(),po.getOrder(),po.getTime(),po.getState(),po.getFrom());
			
//			System.out.println(po.getID()+"  "+po.getOrder()+"  "+po.getTime()+"  "+po.getState()+"  "+po.getFrom());
			return vo;
		}else
		return null;		
	}

	public void init() throws IOException {
		arrivallistdata.init();
		
	}


	public ArrivalListVO record(ArrivalListVO vo) throws IOException{
		ArrivalListPO po=new ArrivalListPO(vo.getID(),vo.getOrder(),vo.getTime(),vo.getState(),vo.getFrom());
		arrivallistdata.insert(po);
		return vo;
	}

	public void delete(ArrivalListVO vo) throws IOException {
		ArrivalListPO po=arrivallistdata.find(vo.getID());
		arrivallistdata.delete(po);
		
	}

	public boolean Approval(String id) throws IOException {
		// TODO 自动生成的方法存根
		return false;
	}

	public void endOpt() throws IOException {
		// TODO 自动生成的方法存根
		
	}


	public ArrivalListDataService getArrivalListData() {
		DataFactory df;
		try{
			df=(DataFactory)Naming.lookup("rmi://192.168.191.1:1099/df");
		return df.getArrivalListData();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
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
