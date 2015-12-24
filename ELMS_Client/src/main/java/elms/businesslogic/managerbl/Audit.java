package elms.businesslogic.managerbl;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import elms.businesslogic.invoicebl.ArrivalListBL;
import elms.businesslogic.invoicebl.IncomeListBL;
import elms.businesslogic.invoicebl.LoadingListBL;
import elms.businesslogic.invoicebl.LoadingListZZBL;
import elms.businesslogic.invoicebl.RecivalListBL;
import elms.businesslogic.invoicebl.SendingListBL;
import elms.businesslogic.invoicebl.TransferListBL;
import elms.vo.ArrivalListVO;
import elms.vo.IncomeListVO;
import elms.vo.LoadingListVO;
import elms.vo.LoadingListZZVO;
import elms.vo.RecivalListVO;
import elms.vo.SendingListVO;
import elms.vo.TransferListVO;

public class Audit {
	SendingListBL sl;
	ArrayList<SendingListVO> noaudit_sendinglist=new ArrayList<SendingListVO>();
	
	ArrivalListBL al;
	ArrayList<ArrivalListVO> noaudit_arrivallist=new ArrayList<ArrivalListVO>();
	
	IncomeListBL il;
	ArrayList<IncomeListVO> noaudit_IncomeList=new ArrayList<IncomeListVO>();
	
	LoadingListBL ll;
	ArrayList<LoadingListVO> noaudit_LoadingList=new ArrayList<LoadingListVO>();
	
	LoadingListZZBL llz;
	ArrayList<LoadingListZZVO> noaudit_LoadingListZZ=new ArrayList<LoadingListZZVO>();
	
	RecivalListBL rl;
	ArrayList<RecivalListVO> noaudit_RecivalList=new ArrayList<RecivalListVO>();
	
	TransferListBL tl;
	ArrayList<TransferListVO> noaudit_TransferList=new ArrayList<TransferListVO>();
	
	
	
	
	public Audit() throws IOException{
		sl=new SendingListBL();
		noaudit_sendinglist=sl.findNoaudit();
		
		al=new ArrivalListBL();
		noaudit_arrivallist=al.findNoaudit();
		
		il=new IncomeListBL();
		noaudit_IncomeList=il.findNoaudit();
		
		ll=new LoadingListBL();
		noaudit_LoadingList=ll.findNoaudit();
		
		llz=new LoadingListZZBL();
		noaudit_LoadingListZZ=llz.findNoaudit();
		
		rl=new RecivalListBL();
		noaudit_RecivalList=rl.findNoaudit();
		
		tl=new TransferListBL();
		noaudit_TransferList=tl.findNoaudit();
		
		
		
		
	}
	
	public void audit_sendinglist(String id) throws RemoteException, IOException{
		sl.AgreeAudit(id);
	}
	
	public void no_audit_sendinglist(String id) throws RemoteException, IOException{
		sl.RefuseAudit(id);
	}
	
	public ArrayList<SendingListVO> getnoaudit_sendinglist() throws IOException{
		noaudit_sendinglist=sl.findNoaudit();
		return noaudit_sendinglist;		
	}
	
	
	
	
		
	
	public void audit_arrivallist(String id) throws RemoteException, IOException{
		al.AgreeAudit(id);
	}
	
	public void no_audit_arrivallist(String id) throws RemoteException, IOException{
		al.RefuseAudit(id);
	}
	
	public ArrayList<ArrivalListVO> getnoaudit_arrivallist() throws IOException{
		noaudit_arrivallist=al.findNoaudit();
		return noaudit_arrivallist;		
	}
	
	
	
	
	public void audit_IncomeList(String id) throws RemoteException, IOException{
		il.AgreeAudit(id);
	}
	
	public void no_audit_IncomeList(String id) throws RemoteException, IOException{
		il.RefuseAudit(id);
	}
	
	public ArrayList<IncomeListVO> getnoaudit_IncomeList() throws IOException{
		noaudit_IncomeList=il.findNoaudit();
		return noaudit_IncomeList;		
	}
	
	
	
	public void audit_LoadingList(String id) throws RemoteException, IOException{
		ll.AgreeAudit(id);
	}
	
	public void no_audit_LoadingList(String id) throws RemoteException, IOException{
		ll.RefuseAudit(id);
	}
	
	public ArrayList<LoadingListVO> getnoaudit_LoadingList() throws IOException{
		noaudit_LoadingList=ll.findNoaudit();
		return noaudit_LoadingList;		
	}
	
	
	
	
	
	public void audit_LoadingListZZ(String id) throws RemoteException, IOException{
		llz.AgreeAudit(id);
	}
	
	public void no_audit_LoadingListZZ(String id) throws RemoteException, IOException{
		llz.RefuseAudit(id);
	}
	
	public ArrayList<LoadingListZZVO> getnoaudit_LoadingListZZ() throws IOException{
		noaudit_LoadingListZZ=llz.findNoaudit();
		return noaudit_LoadingListZZ;		
	}
	
	
	
	public void audit_RecivalList(String id) throws RemoteException, IOException{
		rl.AgreeAudit(id);
	}
	
	public void no_audit_RecivalList(String id) throws RemoteException, IOException{
		rl.RefuseAudit(id);
	}
	
	public ArrayList<RecivalListVO> getnoaudit_RecivalList() throws IOException{
		noaudit_RecivalList=rl.findNoaudit();
		return noaudit_RecivalList;		
	}
	
	
	
	public void audit_TransferList(String id) throws RemoteException, IOException{
		tl.AgreeAudit(id);
	}
	
	public void no_audit_TransferList(String id) throws RemoteException, IOException{
		tl.RefuseAudit(id);
	}
	
	public ArrayList<TransferListVO> getnoaudit_TransferList() throws IOException{
		noaudit_TransferList=tl.findNoaudit();
		return noaudit_TransferList;		
	}
	
	
}
