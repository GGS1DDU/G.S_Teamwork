package elms.businesslogic_service.memberblservice;

import java.io.IOException;

import elms.vo.DriverVO;

public interface DriverBLService {

	public DriverVO inquiry(String id) throws IOException;
	
	public DriverVO record(DriverVO vo)throws IOException;
	
	public void init() throws IOException;
	
	public void delete(DriverVO vo) throws IOException;
	
	public void endOpt() throws IOException;

}
