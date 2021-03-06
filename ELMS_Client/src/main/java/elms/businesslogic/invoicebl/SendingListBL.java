package elms.businesslogic.invoicebl;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;

import elms.businesslogic_service.invoiceblservice.SendingListBLService;
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
//import elms.dataservice.logdataservice.LogDataService;
import elms.dataservice.managerdataservice.FreightStrategyDataService;
import elms.dataservice.managerdataservice.StaffDataService;
import elms.dataservice.memberdataservice.CarDataService;
import elms.dataservice.memberdataservice.DriverDataService;
import elms.dataservice.storagedataservice.StorageDataService;
import elms.dataservice.userdataservice.UserDataService;
import elms.po.SendingListPO;
import elms.vo.SendingListVO;

public class SendingListBL implements SendingListBLService,DataFactory{
	SendingListDataService sendinglistdata;	
//
	public static void main(String[] args) throws IOException{
		
		SendingListBL sl=new SendingListBL();
		sl.init();
		SendingListVO vo1=new SendingListVO("6666666666","0000000001","zwh","2015-12-18","南京市鼓楼营业厅","zwh2","提交");
		SendingListVO vo2=new SendingListVO("6666666667","0000000001","zwh","2015-12-18","南京市鼓楼营业厅","zwh3","提交");
		SendingListVO vo3=new SendingListVO("6666666668","0000000001","zwh","2015-12-18","南京市鼓楼营业厅","zwh4","提交");
		SendingListVO vo4=new SendingListVO("6666666669","0000000001","zwh","2015-12-18","南京市鼓楼营业厅","zwh4","提交");
		
		sl.record(vo1);sl.record(vo2);sl.record(vo3);sl.record(vo4);
		

		sl.RefuseAudit("6666666669");
		sl.RefuseAudit("6666666666");
		
		ArrayList<SendingListVO> arr=sl.findByMakerAndNoaudit("zwh2");
		
		for(int i=0;i<arr.size();i++){
			System.out.println(arr.get(i).getID());
		}
		
	}
//
	
	public SendingListBL(){
		sendinglistdata=getSendingListData();
	}
	
	public SendingListVO inquiry(String id) throws IOException {
		SendingListPO po=sendinglistdata.find(id);
		if(po!=null){
			SendingListVO vo=new SendingListVO(po.getID(),po.getOrderID(),po.getCourier(),po.getTime(),po.getPlace(),po.getMaker(),po.getAuditState());
			return vo;
		}else{
		return null;
		}
	}

	public void init() throws IOException {
		sendinglistdata.init();	
		
	}

	public SendingListVO record(SendingListVO vo) throws IOException{
//		DealBL dealdata=new DealBL();
		SendingListPO po=new SendingListPO(vo.getID(),vo.getOrderID(),vo.getCourier(),vo.getTime(),vo.getPlace(),vo.getMaker(),vo.getAuditState());
		sendinglistdata.insert(po);
//		dealdata.updataTrack(po.getOrderID(), "到达"+po.getPlace());
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
	public ArrayList<SendingListVO> findNoaudit() throws IOException{
		ArrayList<SendingListPO> all=sendinglistdata.findall();
		ArrayList<SendingListVO> no_audit=new ArrayList<SendingListVO>(); 
		for(int i=0;i<all.size();i++){		
			if(all.get(i).getAuditState().equals("提交")){
			SendingListVO vo=new SendingListVO(all.get(i).getID(),all.get(i).getOrderID(),all.get(i).getCourier(),all.get(i).getTime(),all.get(i).getPlace(),all.get(i).getMaker(),all.get(i).getAuditState());
			no_audit.add(vo);		
			}							
		}				
		return no_audit;
	}
		
	//返回这个maker的所有处在"草稿"状态的单据,测试可用。
	public ArrayList<SendingListVO> findByMakerAndNoaudit(String maker) throws IOException{
		ArrayList<SendingListPO> all=sendinglistdata.findall();
		ArrayList<SendingListVO> result=new ArrayList<SendingListVO>(); 
		for(int i=0;i<all.size();i++){
			if(all.get(i).getMaker().equals(maker)&&all.get(i).getAuditState().equals("草稿")){
				SendingListVO vo=new SendingListVO(all.get(i).getID(),all.get(i).getOrderID(),all.get(i).getCourier(),all.get(i).getTime(),all.get(i).getPlace(),all.get(i).getMaker(),all.get(i).getAuditState());
				result.add(vo);				
			}
				
		}
			
		return result;
	}
		
	//更新审批状态的方法
	private void update(String id,String auditState) throws IOException{
		if(auditState.equals("提交")){
			SendingListVO vo=inquiry(id);
			SendingListPO po=new SendingListPO(vo.getID(),vo.getOrderID(),vo.getCourier(),vo.getTime(),vo.getPlace(),vo.getMaker(),"提交");
			sendinglistdata.update(po);
		}
			
		else if(auditState.equals("草稿")){
			SendingListVO vo=inquiry(id);
			SendingListPO po=new SendingListPO(vo.getID(),vo.getOrderID(),vo.getCourier(),vo.getTime(),vo.getPlace(),vo.getMaker(),"草稿");
			sendinglistdata.update(po);
		}
			
		//审批后状态
		else{
			SendingListVO vo=inquiry(id);
			SendingListPO po=new SendingListPO(vo.getID(),vo.getOrderID(),vo.getCourier(),vo.getTime(),vo.getPlace(),vo.getMaker(),"审批后");
			sendinglistdata.update(po);
		}
			
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
		
	public UserDataService getUserData() {
		// TODO 自动生成的方法存根
		return null;
	}

	public DealDataService getDealData() {
	    // TODO 自动生成的方法存根
		return null;
	}

	public ArrayList<SendingListVO> inquiryAll() throws IOException {
		// TODO 自动生成的方法存根
		ArrayList<SendingListVO> voarr=new ArrayList<SendingListVO>();
		ArrayList<SendingListPO> poarr=new ArrayList<SendingListPO>();
		poarr=sendinglistdata.findall();
		if(poarr.size()>0){
		for(SendingListPO po:poarr){
			SendingListVO vo=new SendingListVO(po.getID(),po.getOrderID(),po.getCourier(),po.getTime(),po.getPlace(),
					po.getMaker(),po.getAuditState());
			voarr.add(vo);
		}}
		return voarr;
	}
	
	public ArrayList<SendingListVO> inquiryByMaker(String Maker) throws IOException{
		ArrayList<SendingListVO> voarr=new ArrayList<SendingListVO>();
		ArrayList<SendingListPO> poarr=new ArrayList<SendingListPO>();
	    poarr=sendinglistdata.findbymaker(Maker);
	    if(poarr.size()>0){
			for(SendingListPO po:poarr){
				SendingListVO vo=new SendingListVO(po.getID(),po.getOrderID(),po.getCourier(),po.getTime(),po.getPlace(),po.getMaker(),po.getAuditState());
				voarr.add(vo);
			}}
			return voarr;
	}

//	public LogDataService getLogData() throws RemoteException {
//		// TODO 自动生成的方法存根
//		return null;
//	}

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
