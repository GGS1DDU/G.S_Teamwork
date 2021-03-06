package elms.businesslogic.dealbl;


import java.io.IOException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;

import elms.businesslogic_service.dealblservice.DealBlService;
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
import elms.po.DealPO;
import elms.vo.DealVO;

/**
 * @author ZWH
 *
 */


public class DealBL implements DealBlService ,DataFactory{
	DealDataService dealdata;
	/**
	 * 构造方法:从服务器端获取dealdata
	 */
	public DealBL(){
		dealdata=getDealData();
	}
	

	public boolean BuildOrder(DealVO vo) throws IOException {		
		if(FindOrder(vo.getOrderID())==null){
			try{
				DealPO dealpo=new DealPO(vo.getOrderID(),vo.getCourier_name(),vo.getHall(),vo.getDealTime(),vo.getSender_name(),vo.getSender_city(),vo.getSender_company(),vo.getSender_phonenumber(),vo.getReceiver_name(),vo.getReceiver_city(),vo.getReceiver_company(),vo.getReceiver_phonenumber(),vo.getGoods_name(),vo.getGoods_amount(),vo.getGood_weight(),vo.getGood_volume(),vo.getType(),vo.getPack(),vo.getFee(),vo.getDelaydays(),vo.getActualreceiver_name(),vo.getReceivaltime(),vo.getTrack(),vo.getState());
				dealdata.insert(dealpo);
				System.out.println("成功生成新订单，该订单部分信息如下");
				System.out.println("订单号："+dealpo.getOrderID()+" 寄件人:"+dealpo.getSender_name()+" 收件人:"+dealpo.getReceiver_name());
				FindAllOrder();    //可删 
				return true;
			}catch(Exception e){
				e.printStackTrace();
				return false;
			}
		}
		
		else{
			return false;
		}
		
	
	}
	
	public DealVO FindOrder(String orderID) throws IOException  {
		DealPO dealpo=dealdata.find(orderID);
		
		if(dealpo==null){
			return null;
		}
		else{
				DealVO vo=new DealVO(dealpo.getOrderID(),dealpo.getCourier_name(),dealpo.getHall(),dealpo.getDealTime(),dealpo.getSender_name(),dealpo.getSender_city(),dealpo.getSender_company(),dealpo.getSender_phonenumber(),dealpo.getReceiver_name(),dealpo.getReceiver_city(),dealpo.getReceiver_company(),dealpo.getReceiver_phonenumber(),dealpo.getGoods_name(),dealpo.getGoods_amount(),dealpo.getGood_weight(),dealpo.getGood_volume(),dealpo.getType(),dealpo.getPack(),dealpo.getFee(),dealpo.getDelaydays(),dealpo.getActualreceiver_name(),dealpo.getReceivaltime(),dealpo.getTrack(),dealpo.getState());
				return vo;	
		}
	}
	
	

	public ArrayList<DealVO> FindAllOrder() throws IOException{
		ArrayList<DealVO> arr0=new ArrayList<DealVO>();
		ArrayList<DealPO> arr1=dealdata.findall();
		System.out.println(arr1.size());
		for(int i=0;i<arr1.size();i++){
			DealVO vo=new DealVO(arr1.get(i).getOrderID(),arr1.get(i).getCourier_name(),arr1.get(i).getHall(),arr1.get(i).getDealTime(),arr1.get(i).getSender_name(),arr1.get(i).getSender_city(),arr1.get(i).getSender_company(),arr1.get(i).getSender_phonenumber(),arr1.get(i).getReceiver_name(),arr1.get(i).getReceiver_city(),arr1.get(i).getReceiver_company(),arr1.get(i).getReceiver_phonenumber(),arr1.get(i).getGoods_name(),arr1.get(i).getGoods_amount(),arr1.get(i).getGood_weight(),arr1.get(i).getGood_volume(),arr1.get(i).getType(),arr1.get(i).getPack(),arr1.get(i).getFee(),arr1.get(i).getDelaydays(),arr1.get(i).getActualreceiver_name(),arr1.get(i).getReceivaltime(),arr1.get(i).getTrack(),arr1.get(i).getState());
			arr0.add(vo);
		}
		
		System.out.println("系统内部所有订单的部分信息如下：");
		for(int i=0;i<arr0.size();i++){			
			System.out.println("订单号："+arr0.get(i).getOrderID()+" 寄件人:"+arr0.get(i).getSender_name()+"寄件时间:"+arr0.get(i).getDealTime()+"收件人:"+arr0.get(i).getReceiver_name()+" 实际收件人:"+arr0.get(i).getActualreceiver_name()+"收件时间："+arr0.get(i).getReceivaltime());
		}
		return arr0;
		
	}

	public DealVO recipients(String orderid, String realReciever, String time) throws IOException {
		
		DealVO vo=FindOrder(orderid);
		if(vo==null||(!vo.getActualreceiver_name().equals(""))){
			return null;
		}
		else{
			DealPO po=new DealPO(vo.getOrderID(),vo.getCourier_name(),vo.getHall(),vo.getDealTime(),vo.getSender_name(),vo.getSender_city(),vo.getSender_company(),vo.getSender_phonenumber(),vo.getReceiver_name(),vo.getReceiver_city(),vo.getReceiver_company(),vo.getReceiver_phonenumber(),vo.getGoods_name(),vo.getGoods_amount(),vo.getGood_weight(),vo.getGood_volume(),vo.getType(),vo.getPack(),vo.getFee(),vo.getDelaydays(),realReciever,time,vo.getTrack()+",已收件","已送达");
			dealdata.update(po);
			DealVO newvo=new DealVO(vo.getOrderID(),vo.getCourier_name(),vo.getHall(),vo.getDealTime(),vo.getSender_name(),vo.getSender_city(),vo.getSender_company(),vo.getSender_phonenumber(),vo.getReceiver_name(),vo.getReceiver_city(),vo.getReceiver_company(),vo.getReceiver_phonenumber(),vo.getGoods_name(),vo.getGoods_amount(),vo.getGood_weight(),vo.getGood_volume(),vo.getType(),vo.getPack(),vo.getFee(),vo.getDelaydays(),realReciever,time,vo.getTrack()+",已收件","已送达");
			return  newvo;
		}
		
	}

	/**
	 * 根据订单号以及所在营业厅或者中转中心 更新物流信息
	 * @param orderID
	 * @param newTrack 
	 */
	public boolean updataTrack(String orderID,String newTrack) throws IOException{
		DealVO vo=FindOrder(orderID);
		if(vo==null){
			return false;
		}
		else{
			DealPO po=new DealPO(vo.getOrderID(),vo.getCourier_name(),vo.getHall(),vo.getDealTime(),vo.getSender_name(),vo.getSender_city(),vo.getSender_company(),vo.getSender_phonenumber(),vo.getReceiver_name(),vo.getReceiver_city(),vo.getReceiver_company(),vo.getReceiver_phonenumber(),vo.getGoods_name(),vo.getGoods_amount(),vo.getGood_weight(),vo.getGood_volume(),vo.getType(),vo.getPack(),vo.getFee(),vo.getDelaydays(),vo.getActualreceiver_name(),vo.getReceivaltime(),vo.getTrack()+","+newTrack,vo.getState());
			dealdata.update(po);
			return true;
		}
	}
	
	
	
	public void endDealOpt() {
		
	}



	public DealDataService getDealData() {
		DataFactory df;
		try{
			df=(DataFactory)Naming.lookup("rmi://localhost:1099/df");
			return df.getDealData();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public UserDataService getUserData() {
		return null;
	}


	public StorageDataService getStorageData() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	public IncomeDataService getIncomeData() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	public ExpenseDataService getExpenseData() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	public BankAccountDataService getBankAccountData() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	public FreightStrategyDataService getFreightStrategyData()
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	public InitAllDataService getInitData() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	public StaffDataService getStaffData() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	public ArrivalListDataService getArrivalListData() {
		// TODO Auto-generated method stub
		return null;
	}


	public SendingListDataService getSendingListData() {
		// TODO Auto-generated method stub
		return null;
	}


	public IncomeListDataService getIncomeListData() {
		// TODO Auto-generated method stub
		return null;
	}


	public RecivalListDataService getRecivalListData() {
		// TODO Auto-generated method stub
		return null;
	}


	public LoadingListDataService getLoadingListData() {
		// TODO Auto-generated method stub
		return null;
	}


	public TransferListDataService getTransferListData() {
		// TODO Auto-generated method stub
		return null;
	}


	public LoadingListZZDataService getLoadingListZZData() {
		// TODO Auto-generated method stub
		return null;
	}


	public DriverDataService getDriverData() {
		// TODO Auto-generated method stub
		return null;
	}


	public CarDataService getCarData() {
		// TODO Auto-generated method stub
		return null;
	}

}