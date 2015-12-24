package elms.businesslogic_service.invoiceblservice;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import elms.vo.LoadingListZZVO;

public interface LoadingListZZBLService {
	    public LoadingListZZVO inquiry(String id) throws IOException;
	    
	    public ArrayList<LoadingListZZVO> inquiryAll() throws IOException;
		
		public LoadingListZZVO record(LoadingListZZVO vo)throws IOException;
	//	
	    public void reSubmit(String id) throws RemoteException, IOException;
		
		public void RefuseAudit(String id ) throws RemoteException,IOException;
		
		public void AgreeAudit(String id) throws RemoteException,IOException;
		
		public ArrayList<LoadingListZZVO> findByMakerAndNoaudit(String maker) throws IOException;
		
		public ArrayList<LoadingListZZVO> findNoaudit() throws IOException;
	//	
		public void init() throws IOException;
		
		public void delete(LoadingListZZVO vo) throws IOException;
		
		public boolean Approval(String id) throws IOException;
		
		public void endOpt() throws IOException;


}
