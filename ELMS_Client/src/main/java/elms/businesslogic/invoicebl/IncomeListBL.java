package elms.businesslogic.invoicebl;

import java.io.IOException;
import java.rmi.Naming;

import elms.businesslogic_service.invoiceblservice.IncomeListBLService;
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
import elms.po.IncomeListPO;
import elms.vo.IncomeListVO;

public class IncomeListBL implements IncomeListBLService,DataFactory{
    IncomeListDataService incomelistdata;
    
    public IncomeListBL(){
    	incomelistdata=getIncomeListData();
    }
	
	public IncomeListVO inquiry(String id) throws IOException {
		IncomeListPO po=incomelistdata.find(id);
		if(po!=null){
			IncomeListVO vo=new IncomeListVO(po.getID(),po.getPostage(),po.getCourier(),po.getTime(),po.getOrderID(),po.getPlace());
			return vo;
		}else
		return null;
		
	}

	public IncomeListVO record(IncomeListVO vo) throws IOException {
		IncomeListPO po=new IncomeListPO(vo.getID(),vo.getPostage(),vo.getCourier(),vo.getTime(),vo.getOrderID(),vo.getPlace());
		incomelistdata.insert(po);
		return vo;
	}

	public void delete(IncomeListVO vo) throws IOException {
		IncomeListPO po=incomelistdata.find(vo.getID());
		incomelistdata.delete(po);
		
	}
	
	public void init() throws IOException {
		incomelistdata.init();
		
	}
	public boolean Approval(String id) throws IOException {
		// TODO 自动生成的方法存根
		return false;
	}

	public void endOpt() throws IOException {
		// TODO 自动生成的方法存根
		
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
		DataFactory df;
		try{
			df=(DataFactory)Naming.lookup("rmi://localhost:1099/df");
		return df.getIncomeListData();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
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
