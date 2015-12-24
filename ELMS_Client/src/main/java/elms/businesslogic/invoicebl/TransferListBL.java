package elms.businesslogic.invoicebl;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;

import elms.businesslogic_service.invoiceblservice.TransferListBLService;
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
			TransferListVO vo=new TransferListVO(po.getID(),po.getTime(),po.getTransferID(),po.getTransportNum(),po.getDeparture(),
					po.getArrival(),po.getSeatNumber(),po.getSurpervior(),po.getOrderID(),po.getCost(),po.getPlace(),po.getMaker(),
					po.getAuditState());
		    return vo;
		}else
		return null;
	}

	public TransferListVO record(TransferListVO vo) throws IOException {
		TransferListPO po=new TransferListPO(vo.getID(),vo.getTime(),vo.getTransferID(),vo.getTransportNum(),vo.getDeparture(),
				vo.getArrival(),vo.getSeatNumber(),vo.getSurpervior(),vo.getOrderID(),vo.getCost(),vo.getPlace(),vo.getMaker(),
				vo.getAuditState());
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
	public ArrayList<TransferListVO> findNoaudit() throws IOException{
		ArrayList<TransferListPO> all=transferlistdata.findall();
		ArrayList<TransferListVO> no_audit=new ArrayList<TransferListVO>(); 
		for(int i=1;i<all.size();i++){		
			if(all.get(i).getAuditState().equals("提交")){		
				TransferListVO vo=new TransferListVO(all.get(i).getID(),all.get(i).getTime(),all.get(i).getTransferID(),
						all.get(i).getTransportNum(),all.get(i).getDeparture(),all.get(i).getArrival(),all.get(i).getSeatNumber(),
						all.get(i).getSurpervior(),all.get(i).getOrderID(),all.get(i).getCost(),all.get(i).getPlace(),
						all.get(i).getMaker(),all.get(i).getAuditState());		
				no_audit.add(vo);		
			}							
		}				
		return no_audit;
	}
			
	//返回这个maker的所有处在"草稿"状态的单据,测试可用。
	public ArrayList<TransferListVO> findByMakerAndNoaudit(String maker) throws IOException{
		ArrayList<TransferListPO> all=transferlistdata.findall();
		ArrayList<TransferListVO> result=new ArrayList<TransferListVO>(); 
		for(int i=1;i<all.size();i++){
			if(all.get(i).getMaker().equals(maker)&&all.get(i).getAuditState().equals("草稿")){
				TransferListVO vo=new TransferListVO(all.get(i).getID(),all.get(i).getTime(),all.get(i).getTransferID(),
				all.get(i).getTransportNum(),all.get(i).getDeparture(),all.get(i).getArrival(),all.get(i).getSeatNumber(),
				all.get(i).getSurpervior(),all.get(i).getOrderID(),all.get(i).getCost(),all.get(i).getPlace(),
				all.get(i).getMaker(),all.get(i).getAuditState());
				result.add(vo);				
			}
					
		}
				
		return result;
	}
			
	//更新审批状态的方法
	private void update(String id,String auditState) throws IOException{
		if(auditState.equals("提交")){
			TransferListVO vo=inquiry(id);
			TransferListPO po=new TransferListPO(vo.getID(),vo.getTime(),vo.getTransferID(),vo.getTransportNum(),vo.getDeparture(),
					vo.getArrival(),vo.getSeatNumber(),vo.getSurpervior(),vo.getOrderID(),vo.getCost(),vo.getPlace(),vo.getMaker(),"提交");
			transferlistdata.update(po);
		}
				
		else if(auditState.equals("草稿")){
			TransferListVO vo=inquiry(id);
			TransferListPO po=new TransferListPO(vo.getID(),vo.getTime(),vo.getTransferID(),vo.getTransportNum(),vo.getDeparture(),
					vo.getArrival(),vo.getSeatNumber(),vo.getSurpervior(),vo.getOrderID(),vo.getCost(),vo.getPlace(),vo.getMaker(),"草稿");
			transferlistdata.update(po);
		}
				
		//审批后状态
		else{
			TransferListVO vo=inquiry(id);
			TransferListPO po=new TransferListPO(vo.getID(),vo.getTime(),vo.getTransferID(),vo.getTransportNum(),vo.getDeparture(),
					vo.getArrival(),vo.getSeatNumber(),vo.getSurpervior(),vo.getOrderID(),vo.getCost(),vo.getPlace(),vo.getMaker(),"审批后");
			transferlistdata.update(po);
		}
				
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

	public ArrayList<TransferListVO> inquiryAll() throws IOException {
		// TODO 自动生成的方法存根
		ArrayList<TransferListVO> voarr=new ArrayList<TransferListVO>();
		ArrayList<TransferListPO> poarr=new ArrayList<TransferListPO>();
		poarr=transferlistdata.findall();
		for(TransferListPO po:poarr){
			TransferListVO vo=new TransferListVO(po.getID(),po.getTime(),po.getTransferID(),po.getTransportNum(),
					po.getDeparture(),po.getArrival(),po.getSeatNumber(),po.getSurpervior(),po.getOrderID(),po.getCost(),
					po.getPlace(),po.getMaker(),po.getAuditState());
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
}
