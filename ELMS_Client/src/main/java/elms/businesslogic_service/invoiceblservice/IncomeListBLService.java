package elms.businesslogic_service.invoiceblservice;

import java.io.IOException;

import elms.vo.IncomeListVO;

public interface IncomeListBLService {

	public IncomeListVO inquiry(String id) throws IOException;
	
	public IncomeListVO record(IncomeListVO vo)throws IOException;
	
	public void init() throws IOException;
	
	public void delete(IncomeListVO vo) throws IOException;
	
	public boolean Approval(String id) throws IOException;
	
	public void endOpt() throws IOException;

}
