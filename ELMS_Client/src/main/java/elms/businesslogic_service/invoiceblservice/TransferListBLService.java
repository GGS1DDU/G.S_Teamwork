package elms.businesslogic_service.invoiceblservice;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import elms.vo.TransferListVO;


public interface TransferListBLService {

	public TransferListVO inquiry(String id) throws IOException;
	
	public ArrayList<TransferListVO> inquiryAll() throws IOException;
	
	public TransferListVO record(TransferListVO vo)throws IOException;
	
//	
	public void reSubmit(String id) throws RemoteException, IOException;
		
	public void RefuseAudit(String id ) throws RemoteException,IOException;
		
	public void AgreeAudit(String id) throws RemoteException,IOException;
		
	public ArrayList<TransferListVO> findByMakerAndNoaudit(String maker) throws IOException;
		
	public ArrayList<TransferListVO> findNoaudit() throws IOException;

//	
	
	public void init() throws IOException;
	
	public void delete(TransferListVO vo) throws IOException;
	
	public boolean Approval(String id) throws IOException;
	
	public void endOpt() throws IOException;

}
