package elms.businesslogic.storagebl;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import elms.businesslogic_service.storageblservice.StorageBlService;
import elms.dataservice.DataFactory;
import elms.dataservice.dealdataservice.DealDataService;
import elms.dataservice.financedataservice.BankAccountDataService;
import elms.dataservice.financedataservice.ExpenseDataService;
import elms.dataservice.financedataservice.FreightStrategyDataService;
import elms.dataservice.financedataservice.IncomeDataService;
import elms.dataservice.financedataservice.InitAllDataService;
import elms.dataservice.logdataservice.LogDataService;
import elms.dataservice.storagedataservice.StorageDataService;
import elms.dataservice.userdataservice.UserDataService;
import elms.po.StoragePO;
import elms.vo.StorageVO;



public class Storage implements StorageBlService,DataFactory {
    StorageDataService  storage;
    StorageCapacity capacity;
    public Storage(){
    	storage=getStorageData();
    	
    }
   public static void main(String args[]) throws IOException{
  	Storage s=new Storage();
    	ArrayList<StorageVO> arr=new ArrayList<StorageVO>();
    	StorageVO vo=new StorageVO("000125",  "航运区","R2D3L5", "0000000001", "2015-02-14 14:32:10", null,"IN", "南京");
    	StorageVO vo1=new StorageVO("000126","航运区",  "R2D3L4", "0000000002", "2015-02-12 14:32:10", "2015-02-16 14:32:10","OUT", "南京");
    	StorageVO vo2=new StorageVO("000127", "航运区","R2D3L7",  "0000000003", "2015-02-15 14:32:10", "2015-02-16 14:32:10","OUT", "北京");
    	StorageVO vo3=new StorageVO("000128", "航运区","R2D3L1",  "0000000004", "2015-02-16 14:32:10", null,"IN", "南京");
    	StorageVO vo4=new StorageVO("000129", "航运区","R2D3L2",  "0000000005", "2015-02-16 14:32:10", null,"BROKEN", "南京");
     	arr.add(vo);
    	arr.add(vo1);
    	arr.add(vo2);
    	arr.add(vo3);
    	arr.add(vo4);


   // 	s.init();
////    	s.inquiryByTime("2015-02-15 1:00:02", "2015-02-17 17:02:02", "南京");
////    	s.inquiryAll("南京");
////    	System.out.println();
   //	StorageCapacity c=new StorageCapacity("广州");
   //	System.out.println(s.storage_inChoose("汽运区", c));
////    	s.storage_out("000125", "南京");
////    	s.inquiry("000125");
  }
    public boolean orderhasIN(String s) throws IOException{
    	StoragePO po=storage.find(s);
    	if(po!=null) return true;
    	else return false;
    	
    }
    public void init() throws IOException {
    	storage.init();
    
	}
	public ArrayList<StorageVO> inquiryByTime(String time1, String time2,
			String center) throws IOException {
		ArrayList<StorageVO> voarr=new ArrayList<StorageVO>();
		ArrayList<StoragePO> poarr=new ArrayList<StoragePO>();
		poarr=storage.findbytime(time1, time2, center);
		if(poarr.size()!=0){
		for(StoragePO po:poarr){ //System.out.println(po.getId()+"  "+po.getArea()+"  "+po.getSeat()+"  "+po.getOrder()+"  "+po.getTimeIn()+"  "+po.getTimeOut()+"  "+po.getState()+"  "+po.getName());
			StorageVO vo=new StorageVO(po.getId(),po.getArea(),po.getSeat(),po.getOrder(),po.getTimeIn(),po.getTimeOut(),po.getState(),po.getName());
			voarr.add(vo);
		}	
	return voarr;
	}
		else return null;
	}

	public ArrayList<StorageVO> inquiryAll(String center) throws IOException {
		ArrayList<StorageVO> voarr=new ArrayList<StorageVO>();
		ArrayList<StoragePO> poarr=new ArrayList<StoragePO>();
		poarr=storage.findall(center);
		for(StoragePO po:poarr) {
			StorageVO vo=new StorageVO(po.getId(),po.getArea(),po.getSeat(),po.getOrder(),po.getTimeIn(),po.getTimeOut(),po.getState(),po.getName());
			voarr.add(vo);
		}	
	//	for(StorageVO po:voarr) 		System.out.println(po.getId()+"  "+po.getArea()+"  "+po.getSeat()+"  "+po.getOrder()+"  "+po.getTimeIn()+"  "+po.getTimeOut()+"  "+po.getState()+"  "+po.getName());
	return voarr;
	}
	public int storage_inChoose(String area, StorageCapacity center) throws IOException {
		int now=0;
		int capacity;
		int temp;
		if(area.equals("航运区")) capacity=center.getAir();
		else if(area.equals("火车区")) capacity=center.getTrain();
		else if(area.equals("汽运区"))  capacity=center.getTory();
		else capacity=-1;
		temp=center.getTemp();
		ArrayList<StoragePO> poarr=storage.findall(center.getName());
		for(StoragePO po:poarr){
			if(po.getArea().equals(area)) 	++now;
			}
		if((now+1)<=(int)(9*(capacity)/10))  return 1;
		else return -1;
	}

	public StorageVO storage_inRecord(StorageVO vo) throws IOException{
		StoragePO po=new StoragePO(vo.getId(),vo.getArea(),vo.getSeat(),vo.getOrder(),vo.getTimeIn(),vo.getTimeOut(),vo.getState(),vo.getName());
		storage.insert(po);
		return vo;
	}

	public boolean storage_out(String orderID, String center) throws IOException {
			StoragePO po=storage.find(orderID);
		if(po!=null){	Date date=new Date();System.out.println(po.getId()+"  "+po.getArea()+"  "+po.getSeat()+"  "+po.getOrder()+"  "+po.getTimeIn()+"  "+po.getTimeOut()+"  "+po.getState()+"  "+po.getName());
		StoragePO newpo=new StoragePO(po.getId(),po.getArea(),po.getSeat(),po.getOrder(),po.getTimeIn(),date.toLocaleString(),"OUT",po.getName());
		storage.delete(po);
		storage.insert(newpo);
	//System.out.println(newpo.getId()+"  "+newpo.getArea()+"  "+newpo.getSeat()+"  "+newpo.getOrder()+"  "+newpo.getTimeIn()+"  "+newpo.getTimeOut()+"  "+newpo.getState()+"  "+newpo.getName());

		return true;}
		else return false;
	}


	public StorageVO inquiry(String id) throws IOException {
		StoragePO po=storage.find(id);
		if(po!=null){
		StorageVO vo=new StorageVO(po.getId(),po.getArea(),po.getSeat(),po.getOrder(),po.getTimeIn(),po.getTimeOut(),po.getState(),po.getName());
		
//		System.out.println(po.getId()+"  "+po.getArea()+"  "+po.getSeat()+"  "+po.getOrder()+"  "+po.getTimeIn()+"  "+po.getTimeOut()+"  "+po.getState()+"  "+po.getName());
return vo;
		}
		else return null;
	}
public void delete(StorageVO vo) throws IOException {
		StoragePO po=storage.find(vo.getOrder());
		storage.delete(po);
		
	}
	public void endStoreOpt() {
		// TODO Auto-generated method stub
		
	}

	public StorageDataService getStorageData() {
		DataFactory df;
		try{
			df=(DataFactory)Naming.lookup("rmi://192.168.191.1:1099/df");
			return df.getStorageData();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public UserDataService getUserData() {
		// TODO Auto-generated method stub
		return null;
	}

	public DealDataService getDealData() {
		// TODO Auto-generated method stub
		return null;
	}

	public LogDataService getLogData() {
		// TODO Auto-generated method stub
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
	public int storage_inChoose(String area,
			elms.businesslogic.storagebl.StorageCapacity center)
			throws IOException {
		// TODO 自动生成的方法存根
		return 0;
	}
	public void paint(List<StorageVO> temp, String s) throws IOException {
		// TODO 自动生成的方法存根
		
	}
	
	

}
