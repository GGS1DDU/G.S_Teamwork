package elms.businesslogic_service.invoiceblservice;

import java.io.IOException;

import elms.vo.TransferListVO;



public interface TransferListBLService {

	public TransferListVO inquiry(String id) throws IOException;
	
	public TransferListVO record(TransferListVO vo)throws IOException;
	
	public void init() throws IOException;
	
	public void delete(TransferListVO vo) throws IOException;
	
	public boolean Approval(String id) throws IOException;
	
	public void endOpt() throws IOException;

}
