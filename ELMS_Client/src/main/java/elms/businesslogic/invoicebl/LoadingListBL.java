package elms.businesslogic.invoicebl;

import java.io.IOException;
import java.rmi.Naming;

import elms.businesslogic_service.invoiceblservice.LoadingListBLService;
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
import elms.po.LoadingListPO;
import elms.vo.LoadingListVO;

public class LoadingListBL implements LoadingListBLService,DataFactory{
    LoadingListDataService loadinglistdata;
    
    public LoadingListBL(){
    	loadinglistdata=getLoadingListData();
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

	public LoadingListVO inquiry(String id) throws IOException {
		LoadingListPO po=loadinglistdata.find(id);
		if(po!=null){
			LoadingListVO vo=new LoadingListVO(po.getID(),po.getTime(),po.getShopNumber(),po.getTransportNumber(),po.getArrival(),po.getCarNumber(),po.getSurpervior(),po.getSupercargo(),po.getOrderNumber(),po.getCost(),po.getPlace());
			return vo;
		}else
		return null;
	}

	public LoadingListVO record(LoadingListVO vo) throws IOException {
		LoadingListPO po=new LoadingListPO(vo.getID(),vo.getTime(),vo.getShopNumber(),vo.getTransportNumber(),vo.getArrival(),vo.getCarNumber(),vo.getSurpervior(),vo.getSupercargo(),vo.getOrderNumber(),vo.getCost(),vo.getPlace());
		loadinglistdata.insert(po);
		return vo;
	}

	

	public void init() throws IOException {
		loadinglistdata.init();
		
	}

	public void delete(LoadingListVO vo) throws IOException {
		LoadingListPO po=loadinglistdata.find(vo.getID());
		loadinglistdata.delete(po);	
	}

	public boolean Approval(String id) throws IOException {
		// TODO 自动生成的方法存根
		return false;
	}

	public void endOpt() throws IOException {
		// TODO 自动生成的方法存根
		
	}

	public LoadingListDataService getLoadingListData() {
		DataFactory df;
		try{
			df=(DataFactory)Naming.lookup("rmi://localhost:1099/df");
		return df.getLoadingListData();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
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

}
