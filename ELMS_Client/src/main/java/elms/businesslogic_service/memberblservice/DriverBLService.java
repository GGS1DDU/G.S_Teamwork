package elms.businesslogic_service.memberblservice;

import java.io.IOException;
import java.util.ArrayList;

import elms.vo.DriverVO;
import elms.vo.SendingListVO;

public interface DriverBLService {

	public DriverVO inquiry(String id) throws IOException;
	
	public ArrayList<DriverVO> inquiryAll() throws IOException;
	
	public DriverVO record(DriverVO vo)throws IOException;
	
	public void init() throws IOException;
	
	public void delete(DriverVO vo) throws IOException;
	
	public void endOpt() throws IOException;

}
