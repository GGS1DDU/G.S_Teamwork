package elms.businesslogic.invoicebl;

import java.io.IOException;
import java.rmi.Naming;

import elms.businesslogic_service.invoiceblservice.TransferListBLService;
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
import elms.po.TransferListPO;
import elms.vo.TransferListVO;

public class TransferListBL implements TransferListBLService,DataFactory{
    TransferListDataService transferlistdata;
    
    public TransferListBL(){
    	transferlistdata=getTransferListData();
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
		DataFactory df;
		try{
			df=(DataFactory)Naming.lookup("rmi://localhost:1099/df");
		return df.getTransferListData();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	public TransferListVO inquiry(String id) throws IOException {
		TransferListPO po=transferlistdata.find(id);
		if(po!=null){
			TransferListVO vo=new TransferListVO(po.getID(),po.getTime(),po.getTransferID(),po.getTransportNum(),po.getDeparture(),po.getArrival(),po.getSeatNumber(),po.getSurpervior(),po.getOrderID(),po.getCost(),po.getPlace());
		    return vo;
		}else
		return null;
	}

	public TransferListVO record(TransferListVO vo) throws IOException {
		TransferListPO po=new TransferListPO(vo.getID(),vo.getTime(),vo.getTransferID(),vo.getTransportNum(),vo.getDeparture(),vo.getArrival(),vo.getSeatNumber(),vo.getSurpervior(),vo.getOrderID(),vo.getCost(),vo.getPlace());
		transferlistdata.insert(po);
		return vo;
	}

	public void init() throws IOException {
		transferlistdata.init();
		
	}

	public void delete(TransferListVO vo) throws IOException {
		TransferListPO po=transferlistdata.find(vo.getID());
		transferlistdata.delete(po);
		
	}

	public boolean Approval(String id) throws IOException {
		// TODO 自动生成的方法存根
		return false;
	}

	public void endOpt() throws IOException {
		// TODO 自动生成的方法存根
		
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
