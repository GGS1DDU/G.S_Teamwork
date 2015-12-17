package elms.businesslogic.invoicebl;

import java.io.IOException;
import java.rmi.Naming;

import elms.businesslogic_service.invoiceblservice.RecivalListBLService;
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
import elms.po.RecivalListPO;
import elms.vo.RecivalListVO;

public class RecivalListBL implements RecivalListBLService,DataFactory{
    RecivalListDataService recivallistdata;
    
    public RecivalListBL(){
    	recivallistdata=getRecivalListData();
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
		DataFactory df;
		try{
			df=(DataFactory)Naming.lookup("rmi://localhost:1099/df");
            return df.getRecivalListData();		
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	public RecivalListVO inquiry(String id) throws IOException {
		RecivalListPO po=recivallistdata.find(id);
		if(po!=null){
			RecivalListVO vo=new RecivalListVO(po.getID(),po.getTime(),po.getCenterID(),po.getOrderID(),po.getFrom(),po.getState(),po.getPlace());
			
//			System.out.println(po.getID()+"  "+po.getTime()+"  "+po.getCenterID()+"  "+po.getOrderID()+"  "+po.getFrom()+"   "+po.getState());
			return vo;
		}else
		return null;
		
	}

	public RecivalListVO record(RecivalListVO vo) throws IOException {
		RecivalListPO po=new RecivalListPO(vo.getID(),vo.getTime(),vo.getCenterID(),vo.getOrderID(),vo.getFrom(),vo.getState(),vo.getPlace());
		recivallistdata.insert(po);
		return vo;
	}

	public void init() throws IOException {
		recivallistdata.init();
		
	}
	public void delete(RecivalListVO vo) throws IOException {
		RecivalListPO po=recivallistdata.find(vo.getID());
		recivallistdata.delete(po);
	}

	public boolean Approval(String id) throws IOException {
		// TODO 自动生成的方法存根
		return false;
	}

	public void endOpt() throws IOException {
		// TODO 自动生成的方法存根
		
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
