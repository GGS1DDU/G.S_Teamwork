package elms.businesslogic_service.invoiceblservice;

import java.io.IOException;
import elms.vo.ArrivalListVO;

public interface ArrivalListBLService {
	
	public ArrivalListVO inquiry(String id) throws IOException;
	
	public ArrivalListVO record(ArrivalListVO vo)throws IOException;
	
	public void init() throws IOException;
	
	public void delete(ArrivalListVO vo) throws IOException;
	
	public boolean Approval(String id) throws IOException;
	
	public void endOpt() throws IOException;

}
