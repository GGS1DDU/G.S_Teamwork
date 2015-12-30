package elms.businesslogic.memberbl;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;

import elms.businesslogic_service.memberblservice.CarBLService;
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

import elms.dataservice.managerdataservice.FreightStrategyDataService;
import elms.dataservice.managerdataservice.StaffDataService;
import elms.dataservice.memberdataservice.CarDataService;
import elms.dataservice.memberdataservice.DriverDataService;
import elms.dataservice.storagedataservice.StorageDataService;
import elms.dataservice.userdataservice.UserDataService;
import elms.po.CarPO;
import elms.vo.CarVO;

public class CarBL implements CarBLService,DataFactory{
    CarDataService cardata;
    
    public CarBL(){
    	cardata=getCarData();
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
		// TODO 自动生成的方法存根
				return null;
	}

	public CarDataService getCarData() {
		DataFactory df;
		try{
			df=(DataFactory)Naming.lookup("rmi://localhost:1099/df");
		return df.getCarData();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	public CarVO inquiry(String id) throws IOException {
		CarPO po=cardata.find(id);
		if(po!=null){
			CarVO vo=new CarVO(po.getID(),po.getPlateNumber(),po.getUsingTime());
            return vo;
		}else
			return null;
	}

	public CarVO record(CarVO vo) throws IOException {
		CarPO po=new CarPO(vo.getID(),vo.getPlateNumber(),vo.getUsingTime());
		cardata.insert(po);
		return vo;
	}

	public void init() throws IOException {
		cardata.init();
		
	}

	public void delete(CarVO vo) throws IOException {
		CarPO po=cardata.find(vo.getID());
		cardata.delete(po);
		
	}

	public void endOpt() throws IOException {
		// TODO 自动生成的方法存根
		
	}

	public ArrayList<CarVO> inquiryAll() throws IOException {
		// TODO 自动生成的方法存根
		ArrayList<CarVO> voarr=new ArrayList<CarVO>();
		ArrayList<CarPO> poarr=new ArrayList<CarPO>();
		poarr=cardata.findall();
		if(poarr.size()>0){
		for(CarPO po:poarr){
			CarVO vo=new CarVO(po.getID(),po.getPlateNumber(),po.getUsingTime());
			voarr.add(vo);
		}}
		return voarr;
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
