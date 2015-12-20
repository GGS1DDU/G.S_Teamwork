package elms.businesslogic_service.invoiceblservice;

import java.io.IOException;

import elms.vo.RecivalListVO;

public interface RecivalListBLService {

	public RecivalListVO inquiry(String id) throws IOException;
	
	public RecivalListVO record(RecivalListVO vo)throws IOException;
	
	public void init() throws IOException;
	
	public void delete(RecivalListVO vo) throws IOException;
	
	public boolean Approval(String id) throws IOException;
	
	public void endOpt() throws IOException;

}
