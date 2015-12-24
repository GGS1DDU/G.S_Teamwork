package elms.businesslogic.invoicebl;

import java.io.IOException;
import java.rmi.Naming;
//import java.util.ArrayList;


import java.rmi.RemoteException;
import java.util.ArrayList;

import elms.businesslogic_service.invoiceblservice.ArrivalListBLService;
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
import elms.dataservice.logdataservice.LogDataService;
import elms.dataservice.managerdataservice.FreightStrategyDataService;
import elms.dataservice.managerdataservice.StaffDataService;
import elms.dataservice.memberdataservice.CarDataService;
import elms.dataservice.memberdataservice.DriverDataService;
import elms.dataservice.storagedataservice.StorageDataService;
import elms.dataservice.userdataservice.UserDataService;
import elms.po.ArrivalListPO;
import elms.vo.ArrivalListVO;

public class ArrivalListBL implements ArrivalListBLService,DataFactory{
	ArrivalListDataService arrivallistdata;
	
	public ArrivalListBL(){
		arrivallistdata=getArrivalListData();
	}

//	public static void main(String args[]) throws IOException{
//		ArrivalListBL a=new ArrivalListBL();
//		ArrayList<ArrivalListVO> arr=new ArrayList<ArrivalListVO>();
//		ArrivalListVO vo=new ArrivalListVO("al00001","025000201511190000001","2015-11-19","完整","北京");
//		ArrivalListVO vo1=new ArrivalListVO("al00002","025000201511200000002","2015-11-20","损坏","上海");
//        ArrivalListVO vo2=new ArrivalListVO("al00003","025000201511210000003","2015-11-21","丢失","广州");
//        arr.add(vo);
//        arr.add(vo1);
//        arr.add(vo2);
//        
//        a.inquiry("al00001");
//	} 
	
	public UserDataService getUserData() {
		// TODO 自动生成的方法存根
		return null;
	}

	public DealDataService getDealData() {
		// TODO 自动生成的方法存根
		return null;
	}

	public ArrivalListVO inquiry(String id) throws IOException {
		ArrivalListPO po=arrivallistdata.find(id);
		if(po!=null){
			ArrivalListVO vo=new ArrivalListVO(po.getID(),po.getOrder(),po.getTime(),po.getState(),po.getFrom(),po.getPlace(),po.getMaker(),po.getAuditState());
			
//			System.out.println(po.getID()+"  "+po.getOrder()+"  "+po.getTime()+"  "+po.getState()+"  "+po.getFrom());
			return vo;
		}else
		return null;		
	}

	public void init() throws IOException {
		arrivallistdata.init();
		
	}


	public ArrivalListVO record(ArrivalListVO vo) throws IOException{
		ArrivalListPO po=new ArrivalListPO(vo.getID(),vo.getOrder(),vo.getTime(),vo.getState(),vo.getFrom(),vo.getPlace(),vo.getMaker(),vo.getAuditState());
		arrivallistdata.insert(po);
		return vo;
	}

	public void delete(ArrivalListVO vo) throws IOException {
		ArrivalListPO po=arrivallistdata.find(vo.getID());
		arrivallistdata.delete(po);
		
	}

	 //自己这边用，重新提交单据 
	public void reSubmit(String id) throws RemoteException, IOException{
		update(id,"提交");
	}
			
	//总经理用，审批不通过
	public void RefuseAudit(String id ) throws RemoteException,IOException{
		update(id,"草稿");
	}
			
	//总经理用，审批通过。
	public void AgreeAudit(String id) throws RemoteException,IOException{
		update(id,"审批后");
	}


	//返回所有审核状态为“提交”状态的单据。给总经理那边用的。测试可用。
	public ArrayList<ArrivalListVO> findNoaudit() throws IOException{
		ArrayList<ArrivalListPO> all=arrivallistdata.findall();
		ArrayList<ArrivalListVO> no_audit=new ArrayList<ArrivalListVO>(); 
		for(int i=1;i<all.size();i++){		
			if(all.get(i).getAuditState().equals("提交")){
			ArrivalListVO vo=new ArrivalListVO(all.get(i).getID(),all.get(i).getOrder(),all.get(i).getTime(),all.get(i).getState(),all.get(i).getFrom(),all.get(i).getPlace(),all.get(i).getMaker(),all.get(i).getAuditState());
			no_audit.add(vo);		
			}							
		}				
		return no_audit;
	}
			
	//返回这个maker的所有处在"草稿"状态的单据,测试可用。
	public ArrayList<ArrivalListVO> findByMakerAndNoaudit(String maker) throws IOException{
		ArrayList<ArrivalListPO> all=arrivallistdata.findall();
		ArrayList<ArrivalListVO> result=new ArrayList<ArrivalListVO>(); 
		for(int i=1;i<all.size();i++){
			if(all.get(i).getMaker().equals(maker)&&all.get(i).getAuditState().equals("草稿")){
				ArrivalListVO vo=new ArrivalListVO(all.get(i).getID(),all.get(i).getOrder(),all.get(i).getTime(),all.get(i).getState(),all.get(i).getFrom(),all.get(i).getPlace(),all.get(i).getMaker(),all.get(i).getAuditState());
				result.add(vo);				
			}
					
		}
				
		return result;
	}
			
	//更新审批状态的方法
	private void update(String id,String auditState) throws IOException{
		if(auditState.equals("提交")){
			ArrivalListVO vo=inquiry(id);
			ArrivalListPO po=new ArrivalListPO(vo.getID(),vo.getOrder(),vo.getTime(),vo.getState(),vo.getFrom(),vo.getPlace(),vo.getMaker(),"提交");
			arrivallistdata.update(po);
		}
				
		else if(auditState.equals("草稿")){
			ArrivalListVO vo=inquiry(id);
			ArrivalListPO po=new ArrivalListPO(vo.getID(),vo.getOrder(),vo.getTime(),vo.getState(),vo.getFrom(),vo.getPlace(),vo.getMaker(),"草稿");
			arrivallistdata.update(po);
		}
				
		//审批后状态
		else{
			ArrivalListVO vo=inquiry(id);
			ArrivalListPO po=new ArrivalListPO(vo.getID(),vo.getOrder(),vo.getTime(),vo.getState(),vo.getFrom(),vo.getPlace(),vo.getMaker(),"审批后");
			arrivallistdata.update(po);
		}
				
	}
	
	
	public boolean Approval(String id) throws IOException {
		// TODO 自动生成的方法存根
		return false;
	}

	public void endOpt() throws IOException {
		// TODO 自动生成的方法存根
		
	}


	public ArrivalListDataService getArrivalListData() {
		DataFactory df;
		try{
			df=(DataFactory)Naming.lookup("rmi://localhost:1099/df");
		return df.getArrivalListData();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
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
		// TODO 自动生成的方法存根
		return null;
	}

	public ArrayList<ArrivalListVO> inquiryAll() throws IOException {
		ArrayList<ArrivalListVO> voarr=new ArrayList<ArrivalListVO>();
		ArrayList<ArrivalListPO> poarr=new ArrayList<ArrivalListPO>();
		poarr=arrivallistdata.findall();
		for(ArrivalListPO po:poarr){
			ArrivalListVO vo=new ArrivalListVO(po.getID(),po.getOrder(),po.getTime(),po.getState(),po.getFrom(),po.getPlace(),po.getMaker(),po.getAuditState());
			voarr.add(vo);
		}
		return voarr;
	}

	public LogDataService getLogData() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
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

	/*public ArrayList<StorageVO> inquiryAll(String center) throws IOException {
		ArrayList<StorageVO> voarr=new ArrayList<StorageVO>();
		ArrayList<StoragePO> poarr=new ArrayList<StoragePO>();
		poarr=storage.findall(center);
		for(StoragePO po:poarr) {
			StorageVO vo=new StorageVO(po.getId(),po.getArea(),po.getSeat(),po.getOrder(),po.getTimeIn(),po.getTimeOut(),po.getState(),po.getName());
			voarr.add(vo);
		}	
	//	for(StorageVO po:voarr) 		System.out.println(po.getId()+"  "+po.getArea()+"  "+po.getSeat()+"  "+po.getOrder()+"  "+po.getTimeIn()+"  "+po.getTimeOut()+"  "+po.getState()+"  "+po.getName());
	return voarr;
	}*/


	

}
