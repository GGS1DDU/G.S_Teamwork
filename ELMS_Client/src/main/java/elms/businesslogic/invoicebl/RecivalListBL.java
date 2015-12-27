package elms.businesslogic.invoicebl;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;

import elms.businesslogic.dealbl.DealBL;
import elms.businesslogic_service.invoiceblservice.RecivalListBLService;
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
			RecivalListVO vo=new RecivalListVO(po.getID(),po.getdealOrderID(),po.getTime(),po.getCenterID(),po.getOrderID(),po.getFrom(),po.getState(),
					po.getPlace(),po.getMaker(),po.getAuditState());			
			return vo;
		}else
		return null;
		
	}

	public RecivalListVO record(RecivalListVO vo) throws IOException {
//		DealBL dealdata=new DealBL();
		RecivalListPO po=new RecivalListPO(vo.getID(),vo.getdealOrderID(),vo.getTime(),vo.getCenterID(),vo.getOrderID(),vo.getFrom(),vo.getState(),
				vo.getPlace(),vo.getMaker(),vo.getAuditState());
		recivallistdata.insert(po);
//		dealdata.updataTrack(po.getdealOrderID(), "到达"+vo.getPlace()+"中转中心");
		return vo;
	}

	public void init() throws IOException {
		recivallistdata.init();
		
	}
	public void delete(RecivalListVO vo) throws IOException {
		RecivalListPO po=recivallistdata.find(vo.getID());
		recivallistdata.delete(po);
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
	public ArrayList<RecivalListVO> findNoaudit() throws IOException{
		ArrayList<RecivalListPO> all=recivallistdata.findall();
		ArrayList<RecivalListVO> no_audit=new ArrayList<RecivalListVO>(); 
		for(int i=0;i<all.size();i++){		
			if(all.get(i).getAuditState().equals("提交")){
			RecivalListVO vo=new RecivalListVO(all.get(i).getID(),all.get(i).getdealOrderID(),all.get(i).getTime(),all.get(i).getCenterID(),
					all.get(i).getOrderID(),all.get(i).getFrom(),all.get(i).getState(),all.get(i).getPlace(),
					all.get(i).getMaker(),all.get(i).getAuditState());
			no_audit.add(vo);		
			}							
		}				
		return no_audit;
	}
			
	//返回这个maker的所有处在"草稿"状态的单据,测试可用。
	public ArrayList<RecivalListVO> findByMakerAndNoaudit(String maker) throws IOException{
		ArrayList<RecivalListPO> all=recivallistdata.findall();
		ArrayList<RecivalListVO> result=new ArrayList<RecivalListVO>(); 
		for(int i=0;i<all.size();i++){
			if(all.get(i).getMaker().equals(maker)&&all.get(i).getAuditState().equals("草稿")){
				RecivalListVO vo=new RecivalListVO(all.get(i).getID(),all.get(i).getdealOrderID(),all.get(i).getTime(),all.get(i).getCenterID(),
						all.get(i).getOrderID(),all.get(i).getFrom(),all.get(i).getState(),all.get(i).getPlace(),
						all.get(i).getMaker(),all.get(i).getAuditState());
				result.add(vo);				
			}
					
		}
				
		return result;
	}
			
	//更新审批状态的方法
	private void update(String id,String auditState) throws IOException{
		if(auditState.equals("提交")){
			RecivalListVO vo=inquiry(id);
			RecivalListPO po=new RecivalListPO(vo.getID(),vo.getdealOrderID(),vo.getTime(),vo.getCenterID(),vo.getOrderID(),vo.getFrom(),
					vo.getState(),vo.getPlace(),vo.getMaker(),"提交");
			recivallistdata.update(po);
		}
				
		else if(auditState.equals("草稿")){
			RecivalListVO vo=inquiry(id);
			RecivalListPO po=new RecivalListPO(vo.getID(),vo.getdealOrderID(),vo.getTime(),vo.getCenterID(),vo.getOrderID(),vo.getFrom(),
					vo.getState(),vo.getPlace(),vo.getMaker(),"草稿");
			recivallistdata.update(po);
		}
				
		//审批后状态
		else{
			RecivalListVO vo=inquiry(id);
			RecivalListPO po=new RecivalListPO(vo.getID(),vo.getdealOrderID(),vo.getTime(),vo.getCenterID(),vo.getOrderID(),vo.getFrom(),
					vo.getState(),vo.getPlace(),vo.getMaker(),"审批后");
			recivallistdata.update(po);
		}
				
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
	public ArrayList<RecivalListVO> inquiryAll() throws IOException {
		// TODO 自动生成的方法存根
		ArrayList<RecivalListVO> voarr=new ArrayList<RecivalListVO>();
		ArrayList<RecivalListPO> poarr=new ArrayList<RecivalListPO>();
		poarr=recivallistdata.findall();
		if(poarr.size()>0){
		for(RecivalListPO po:poarr){
			RecivalListVO vo=new RecivalListVO(po.getID(),po.getdealOrderID(),po.getTime(),po.getCenterID(),po.getOrderID(),po.getFrom(),
					po.getState(),po.getPlace(),po.getMaker(),po.getAuditState());
			voarr.add(vo);
		}}
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
}
