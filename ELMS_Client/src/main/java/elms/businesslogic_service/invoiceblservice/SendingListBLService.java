package elms.businesslogic_service.invoiceblservice;

import java.io.IOException;

import elms.vo.SendingListVO;

public interface SendingListBLService {

	public SendingListVO inquiry(String id) throws IOException;
	
	public SendingListVO record(SendingListVO vo)throws IOException;
	
	public void init() throws IOException;
	
	public void delete(SendingListVO vo) throws IOException;
	
	public boolean Approval(String id) throws IOException;
	
	public void endOpt() throws IOException;

	

}
