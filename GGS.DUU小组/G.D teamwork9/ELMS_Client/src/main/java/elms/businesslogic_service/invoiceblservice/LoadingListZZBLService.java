package elms.businesslogic_service.invoiceblservice;

import java.io.IOException;

import elms.vo.LoadingListZZVO;

public interface LoadingListZZBLService {
	    public LoadingListZZVO inquiry(String id) throws IOException;
		
		public LoadingListZZVO record(LoadingListZZVO vo)throws IOException;
		
		public void init() throws IOException;
		
		public void delete(LoadingListZZVO vo) throws IOException;
		
		public boolean Approval(String id) throws IOException;
		
		public void endOpt() throws IOException;


}
