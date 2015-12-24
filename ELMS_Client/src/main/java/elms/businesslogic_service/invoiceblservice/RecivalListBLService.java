package elms.businesslogic_service.invoiceblservice;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import elms.vo.RecivalListVO;

public interface RecivalListBLService {

	public RecivalListVO inquiry(String id) throws IOException;
	
	public ArrayList<RecivalListVO> inquiryAll() throws IOException;
	
	public RecivalListVO record(RecivalListVO vo)throws IOException;
//	
    public void reSubmit(String id) throws RemoteException, IOException;
	
	public void RefuseAudit(String id ) throws RemoteException,IOException;
	
	public void AgreeAudit(String id) throws RemoteException,IOException;
	
	public ArrayList<RecivalListVO> findByMakerAndNoaudit(String maker) throws IOException;
	
	public ArrayList<RecivalListVO> findNoaudit() throws IOException;
//	
	public void init() throws IOException;
	
	public void delete(RecivalListVO vo) throws IOException;
	
	public boolean Approval(String id) throws IOException;
	
	public void endOpt() throws IOException;

}
