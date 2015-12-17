package elms.businesslogic.invoicebl;

import java.io.IOException;
import java.rmi.Naming;

import elms.businesslogic_service.invoiceblservice.LoadingListZZBLService;
import elms.dataservice.DataFactory;
import elms.dataservice.dealdataservice.DealDataService;
import elms.dataservice.invoicedataservice.ArrivalListDataService;
import elms.dataservice.invoicedataservice.IncomeListDataService;
import elms.dataservice.invoicedataservice.LoadingListDataService;
import elms.dataservice.invoicedataservice.LoadingListZZDataService;
import elms.dataservice.invoicedataservice.RecivalListDataService;
import elms.dataservice.invoicedataservice.SendingListDataService;
import elms.dataservice.invoicedataservice.TransferListDataService;
import elms.dataservice.memberdataservice.CarDataService;
import elms.dataservice.memberdataservice.DriverDataService;
import elms.dataservice.userdataservice.UserDataService;
import elms.po.LoadingListZZPO;
import elms.vo.LoadingListZZVO;

public class LoadingListZZBL implements LoadingListZZBLService,DataFactory{
	LoadingListZZDataService loadinglistzzdata;
	
	public LoadingListZZBL(){
		loadinglistzzdata=getLoadingListZZData();
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
		DataFactory df;
		try{
			df=(DataFactory)Naming.lookup("rmi://localhost:1099/df");
		return df.getLoadingListZZData();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	public LoadingListZZVO inquiry(String id) throws IOException {
		LoadingListZZPO po=loadinglistzzdata.find(id);
		if(po!=null){
			LoadingListZZVO vo=new LoadingListZZVO(po.getID(),po.getTime(),po.getTransportNumber(),po.getArrival(),po.getCarNumber(),po.getSurpervior(),po.getSupercargo(),po.getOrderNumber(),po.getCost(),po.getPlace());
			return vo;
		}else
		return null;	}

	public LoadingListZZVO record(LoadingListZZVO vo) throws IOException {
		LoadingListZZPO po=new LoadingListZZPO(vo.getID(),vo.getTime(),vo.getTransportNumber(),vo.getArrival(),vo.getCarNumber(),vo.getSurpervior(),vo.getSupercargo(),vo.getOrderNumber(),vo.getCost(),vo.getPlace());
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

}
