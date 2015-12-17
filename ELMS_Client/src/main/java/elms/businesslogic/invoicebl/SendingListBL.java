package elms.businesslogic.invoicebl;

import java.io.IOException;
import java.rmi.Naming;

import elms.businesslogic.dealbl.DealBL;
import elms.businesslogic_service.invoiceblservice.SendingListBLService;
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
import elms.po.SendingListPO;
import elms.vo.SendingListVO;

public class SendingListBL implements SendingListBLService,DataFactory{
	SendingListDataService sendinglistdata;
	
	
	
	public SendingListBL(){
		sendinglistdata=getSendingListData();
	}

	
	public UserDataService getUserData() {
		// TODO 自动生成的方法存根
		return null;
	}

	public DealDataService getDealData() {
		// TODO 自动生成的方法存根
		return null;
	}

	public SendingListVO inquiry(String id) throws IOException {
		SendingListPO po=sendinglistdata.find(id);
		if(po!=null){
			SendingListVO vo=new SendingListVO(po.getID(),po.getOrderID(),po.getCourier(),po.getTime(),po.getPlace());
			
//			System.out.println(po.getID()+"   "+po.getOrderID()+"   "+po.getCourier()+"   "+po.getTime());
			return vo;
		}else{
		return null;
		}
	}

	public void init() throws IOException {
		sendinglistdata.init();
		
	}

	public SendingListVO record(SendingListVO vo) throws IOException{
		DealBL dealdata=new DealBL();
		SendingListPO po=new SendingListPO(vo.getID(),vo.getOrderID(),vo.getCourier(),vo.getTime(),vo.getPlace());
		sendinglistdata.insert(po);
		dealdata.updataTrack(po.getOrderID(), "到达"+po.getPlace());
		return vo;
		
	}

	public void delete(SendingListVO vo) throws IOException {
	    SendingListPO po=sendinglistdata.find(vo.getID());
		sendinglistdata.delete(po);
		
	}

	public boolean Approval(String id) throws IOException {
		// TODO 自动生成的方法存根
		return false;
	}

	public void endOpt() throws IOException {
		// TODO 自动生成的方法存根
		
	}


	public SendingListDataService getSendingListData() {
		DataFactory df;
		try{
			df=(DataFactory)Naming.lookup("rmi://localhost:1099/df");
		return df.getSendingListData();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
	}


	public ArrivalListDataService getArrivalListData() {
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

}
