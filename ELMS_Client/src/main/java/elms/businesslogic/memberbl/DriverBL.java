package elms.businesslogic.memberbl;

import java.io.IOException;
import java.rmi.Naming;

import elms.businesslogic_service.memberblservice.DriverBLService;
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
			DriverVO vo=new DriverVO(po.getID(),po.getName(),po.getBirthday(),po.getID(),po.getCallNumber(),po.getGender(),po.getLicenseDate());
            return vo;
		}else
			return null;
	}

	public DriverVO record(DriverVO vo) throws IOException {
		DriverPO po=new DriverPO(vo.getID(),vo.getName(),vo.getBirthday(),vo.getID(),vo.getCallNumber(),vo.getGender(),vo.getLicenseDate());
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

}
