package elms.businesslogic.invoicebl;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;

import elms.businesslogic_service.invoiceblservice.LoadingListBLService;
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
import elms.po.LoadingListPO;
import elms.vo.LoadingListVO;

public class LoadingListBL implements LoadingListBLService,DataFactory{
    LoadingListDataService loadinglistdata;
    
    public LoadingListBL(){
    	loadinglistdata=getLoadingListData();
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

	public LoadingListVO inquiry(String id) throws IOException {
		LoadingListPO po=loadinglistdata.find(id);
		if(po!=null){
			LoadingListVO vo=new LoadingListVO(po.getID(),po.getTime(),po.getShopNumber(),po.getTransportNumber(),po.getArrival(),
					po.getCarNumber(),po.getSurpervior(),po.getSupercargo(),po.getOrderNumber(),po.getCost(),po.getPlace(),
					po.getMaker(),po.getAuditState());
			return vo;
		}else
		return null;
	}

	public LoadingListVO record(LoadingListVO vo) throws IOException {
		LoadingListPO po=new LoadingListPO(vo.getID(),vo.getTime(),vo.getShopNumber(),vo.getTransportNumber(),vo.getArrival(),
				vo.getCarNumber(),vo.getSurpervior(),vo.getSupercargo(),vo.getOrderNumber(),vo.getCost(),vo.getPlace(),
				vo.getMaker(),vo.getAuditState());
		loadinglistdata.insert(po);
		return vo;
	}

	

	public void init() throws IOException {
		loadinglistdata.init();
		
	}

	public void delete(LoadingListVO vo) throws IOException {
		LoadingListPO po=loadinglistdata.find(vo.getID());
		loadinglistdata.delete(po);	
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
	public ArrayList<LoadingListVO> findNoaudit() throws IOException{
		ArrayList<LoadingListPO> all=loadinglistdata.findall();
		ArrayList<LoadingListVO> no_audit=new ArrayList<LoadingListVO>(); 
		for(int i=0;i<all.size();i++){		
			if(all.get(i).getAuditState().equals("提交")){
			LoadingListVO vo=new LoadingListVO(all.get(i).getID(),all.get(i).getTime(),all.get(i).getShopNumber(),
					all.get(i).getTransportNumber(),all.get(i).getArrival(),all.get(i).getCarNumber(),all.get(i).getSurpervior(),
					all.get(i).getSupercargo(),all.get(i).getOrderNumber(),all.get(i).getCost(),all.get(i).getPlace(),
					all.get(i).getMaker(),all.get(i).getAuditState());
			no_audit.add(vo);		
			}							
		}				
		return no_audit;
	}
			
	//返回这个maker的所有处在"草稿"状态的单据,测试可用。
	public ArrayList<LoadingListVO> findByMakerAndNoaudit(String maker) throws IOException{
		ArrayList<LoadingListPO> all=loadinglistdata.findall();
		ArrayList<LoadingListVO> result=new ArrayList<LoadingListVO>(); 
		for(int i=0;i<all.size();i++){
			if(all.get(i).getMaker().equals(maker)&&all.get(i).getAuditState().equals("草稿")){
				LoadingListVO vo=new LoadingListVO(all.get(i).getID(),all.get(i).getTime(),all.get(i).getShopNumber(),
						all.get(i).getTransportNumber(),all.get(i).getArrival(),all.get(i).getCarNumber(),all.get(i).getSurpervior(),
						all.get(i).getSupercargo(),all.get(i).getOrderNumber(),all.get(i).getCost(),all.get(i).getPlace(),
						all.get(i).getMaker(),all.get(i).getAuditState());
				result.add(vo);				
			}
					
		}
				
		return result;
	}
			
	//更新审批状态的方法
	private void update(String id,String auditState) throws IOException{
		if(auditState.equals("提交")){
			LoadingListVO vo=inquiry(id);
			LoadingListPO po=new LoadingListPO(vo.getID(),vo.getTime(),vo.getShopNumber(),vo.getTransportNumber(),vo.getArrival(),
					vo.getCarNumber(),vo.getSurpervior(),vo.getSupercargo(),vo.getOrderNumber(),vo.getCost(),vo.getPlace(),vo.getMaker(),"提交");
			loadinglistdata.update(po);
		}
			
		else if(auditState.equals("草稿")){
			LoadingListVO vo=inquiry(id);
			LoadingListPO po=new LoadingListPO(vo.getID(),vo.getTime(),vo.getShopNumber(),vo.getTransportNumber(),vo.getArrival(),
					vo.getCarNumber(),vo.getSurpervior(),vo.getSupercargo(),vo.getOrderNumber(),vo.getCost(),vo.getPlace(),vo.getMaker(),"草稿");
			loadinglistdata.update(po);
		}
				
		//审批后状态
		else{
			LoadingListVO vo=inquiry(id);
			LoadingListPO po=new LoadingListPO(vo.getID(),vo.getTime(),vo.getShopNumber(),vo.getTransportNumber(),vo.getArrival(),
					vo.getCarNumber(),vo.getSurpervior(),vo.getSupercargo(),vo.getOrderNumber(),vo.getCost(),vo.getPlace(),vo.getMaker(),"审批后");
			loadinglistdata.update(po);
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
		DataFactory df;
		try{
			df=(DataFactory)Naming.lookup("rmi://localhost:1099/df");
		return df.getLoadingListData();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
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

	public ArrayList<LoadingListVO> inquiryAll() throws IOException {
		// TODO 自动生成的方法存根
		ArrayList<LoadingListVO> voarr=new ArrayList<LoadingListVO>();
		ArrayList<LoadingListPO> poarr=new ArrayList<LoadingListPO>();
		poarr=loadinglistdata.findall();
		if(poarr.size()>0){
		for(LoadingListPO po:poarr){
			LoadingListVO vo=new LoadingListVO(po.getID(),po.getTime(),po.getShopNumber(),po.getTransportNumber(),
					po.getArrival(),po.getCarNumber(),po.getSurpervior(),po.getSupercargo(),po.getOrderNumber(),po.getCost(),
					po.getPlace(),po.getMaker(),po.getAuditState());
			voarr.add(vo);
		}
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

}
