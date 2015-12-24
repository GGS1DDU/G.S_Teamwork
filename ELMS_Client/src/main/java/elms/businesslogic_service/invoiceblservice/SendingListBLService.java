package elms.businesslogic_service.invoiceblservice;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import elms.vo.SendingListVO;

public interface SendingListBLService {

	public SendingListVO inquiry(String id) throws IOException;
	
	public ArrayList<SendingListVO> inquiryAll() throws IOException;
	
	public SendingListVO record(SendingListVO vo)throws IOException;
	
//	
    public void reSubmit(String id) throws RemoteException, IOException;
	
	public void RefuseAudit(String id ) throws RemoteException,IOException;
	
	public void AgreeAudit(String id) throws RemoteException,IOException;
	
	public ArrayList<SendingListVO> findByMakerAndNoaudit(String maker) throws IOException;
	
	public ArrayList<SendingListVO> findNoaudit() throws IOException;
//	
	
	public void init() throws IOException;
	
	public void delete(SendingListVO vo) throws IOException;
	
	public boolean Approval(String id) throws IOException;
	
	public void endOpt() throws IOException;

	

}
