package elms.businesslogic.invoicebl;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;

import elms.businesslogic.HallInfo;
import elms.businesslogic.financebl.inandex.IncomeManager;
import elms.businesslogic_service.invoiceblservice.IncomeListBLService;
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
			IncomeListVO vo=new IncomeListVO(po.getID(),po.getPostage(),po.getCourier(),po.getTime(),po.getOrderID(),
					po.getPlace(),po.getMaker(),po.getAuditState());
			return vo;
		}else
		return null;
		
	}

	public IncomeListVO record(IncomeListVO vo) throws IOException {
		IncomeListPO po=new IncomeListPO(vo.getID(),vo.getPostage(),vo.getCourier(),vo.getTime(),vo.getOrderID(),
				vo.getPlace(),vo.getMaker(),vo.getAuditState());
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
	
	//计算每天各个营业厅的收入总额,调用finance的收入项中的addHallInfo
	//因为一个单据生成者只会提交本营业厅的，所以实际是按照生成者去find
    public ArrayList<String> addByCenter(IncomeListVO vo,String date,String id) throws IOException{
    	ArrayList<String> res=new ArrayList<String>();
    	ArrayList<IncomeListPO> all=incomelistdata.findall();

    	double income=0.0;
    	String hall="";
    	for(int i=1;i<all.size();i++){
    		if(all.get(i).getTime().equals(date)){
    			if(all.get(i).getMaker()==id){
    				income+=all.get(i).getPostage();
    				hall=all.get(i).getPlace();
    			}
    		}
    	}
    	HallInfo hallinfo=new HallInfo(date,income,hall+"营业厅");
    	   	
    	IncomeManager incomemanagerdate=new IncomeManager();
    	incomemanagerdate.addHallInfo(hallinfo);
    	
    	res.add(date);res.add(String.valueOf(income));res.add(hall); 	
    	return res;
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
	public ArrayList<IncomeListVO> findNoaudit() throws IOException{
		ArrayList<IncomeListPO> all=incomelistdata.findall();
		ArrayList<IncomeListVO> no_audit=new ArrayList<IncomeListVO>(); 
		for(int i=0;i<all.size();i++){		
			if(all.get(i).getAuditState().equals("提交")){		
				IncomeListVO vo=new IncomeListVO(all.get(i).getID(),all.get(i).getPostage(),all.get(i).getCourier(),
						all.get(i).getTime(),all.get(i).getOrderID(),all.get(i).getPlace(),all.get(i).getMaker(),
						all.get(i).getAuditState());		
				no_audit.add(vo);		
			}							
		}				
		return no_audit;
	}
			
	//返回这个maker的所有处在"草稿"状态的单据,测试可用。
	public ArrayList<IncomeListVO> findByMakerAndNoaudit(String maker) throws IOException{
		ArrayList<IncomeListPO> all=incomelistdata.findall();
		ArrayList<IncomeListVO> result=new ArrayList<IncomeListVO>(); 
		for(int i=0;i<all.size();i++){
			if(all.get(i).getMaker().equals(maker)&&all.get(i).getAuditState().equals("草稿")){
				IncomeListVO vo=new IncomeListVO(all.get(i).getID(),all.get(i).getPostage(),all.get(i).getCourier(),
						all.get(i).getTime(),all.get(i).getOrderID(),all.get(i).getPlace(),all.get(i).getMaker(),
						all.get(i).getAuditState());
				result.add(vo);				
			}
					
		}
				
		return result;
	}
				
	//更新审批状态的方法
	private void update(String id,String auditState) throws IOException{
		if(auditState.equals("提交")){
			IncomeListVO vo=inquiry(id);
			IncomeListPO po=new IncomeListPO(vo.getID(),vo.getPostage(),vo.getCourier(),vo.getTime(),vo.getOrderID(),
					vo.getPlace(),vo.getMaker(),"提交");
			incomelistdata.update(po);
		}
				
		else if(auditState.equals("草稿")){
			IncomeListVO vo=inquiry(id);
			IncomeListPO po=new IncomeListPO(vo.getID(),vo.getPostage(),vo.getCourier(),vo.getTime(),vo.getOrderID(),
					vo.getPlace(),vo.getMaker(),"草稿");
			incomelistdata.update(po);
		}
				
		//审批后状态
		else{
			IncomeListVO vo=inquiry(id);
			IncomeListPO po=new IncomeListPO(vo.getID(),vo.getPostage(),vo.getCourier(),vo.getTime(),vo.getOrderID(),
					vo.getPlace(),vo.getMaker(),"审批后");
			incomelistdata.update(po);
		}
				
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

	public ArrayList<IncomeListVO> inquiryAll() throws IOException {
		ArrayList<IncomeListVO> voarr=new ArrayList<IncomeListVO>();
		ArrayList<IncomeListPO> poarr=new ArrayList<IncomeListPO>();
		poarr=incomelistdata.findall();
		if(poarr.size()>0){
		for(IncomeListPO po:poarr){
			IncomeListVO vo=new IncomeListVO(po.getID(),po.getPostage(),po.getCourier(),po.getTime(),po.getOrderID(),po.getPlace(),po.getMaker(),po.getAuditState());
            voarr.add(vo);
		}}
		return voarr;
	}
	
	public ArrayList<IncomeListVO> inquiryByMaker(String Maker) throws IOException{
		ArrayList<IncomeListVO> voarr=new ArrayList<IncomeListVO>();
		ArrayList<IncomeListPO> poarr=new ArrayList<IncomeListPO>();
	    poarr=incomelistdata.findbymaker(Maker);
	    if(poarr.size()>0){
			for(IncomeListPO po:poarr){
				IncomeListVO vo=new IncomeListVO(po.getID(),po.getPostage(),po.getCourier(),po.getTime(),po.getOrderID(),po.getPlace(),po.getMaker(),po.getAuditState());
				voarr.add(vo);
			}}
			return voarr;
	}
//
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
