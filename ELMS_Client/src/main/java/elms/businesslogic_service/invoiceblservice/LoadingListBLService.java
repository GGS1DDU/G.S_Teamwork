package elms.businesslogic_service.invoiceblservice;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import elms.vo.LoadingListVO;

public interface LoadingListBLService {
    public LoadingListVO inquiry(String id) throws IOException;
    
    public ArrayList<LoadingListVO> inquiryAll() throws IOException;
	
	public LoadingListVO record(LoadingListVO vo)throws IOException;
//	
    public void reSubmit(String id) throws RemoteException, IOException;
	
	public void RefuseAudit(String id ) throws RemoteException,IOException;
	
	public void AgreeAudit(String id) throws RemoteException,IOException;
	
	public ArrayList<LoadingListVO> findByMakerAndNoaudit(String maker) throws IOException;
	
	public ArrayList<LoadingListVO> findNoaudit() throws IOException;
//	
	public void init() throws IOException;
	
	public void delete(LoadingListVO vo) throws IOException;
	
	public boolean Approval(String id) throws IOException;
	
	public void endOpt() throws IOException;

}
