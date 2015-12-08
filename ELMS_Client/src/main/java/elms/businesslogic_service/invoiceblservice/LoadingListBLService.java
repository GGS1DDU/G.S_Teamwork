package elms.businesslogic_service.invoiceblservice;

import java.io.IOException;

import elms.vo.LoadingListVO;

public interface LoadingListBLService {
    public LoadingListVO inquiry(String id) throws IOException;
	
	public LoadingListVO record(LoadingListVO vo)throws IOException;
	
	public void init() throws IOException;
	
	public void delete(LoadingListVO vo) throws IOException;
	
	public boolean Approval(String id) throws IOException;
	
	public void endOpt() throws IOException;

}
