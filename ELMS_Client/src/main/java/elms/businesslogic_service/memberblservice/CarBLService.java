package elms.businesslogic_service.memberblservice;

import java.io.IOException;
import java.util.ArrayList;

import elms.vo.CarVO;

public interface CarBLService {

	public CarVO inquiry(String id) throws IOException;
	
	public ArrayList<CarVO> inquiryAll() throws IOException;
	
	
	public CarVO record(CarVO vo)throws IOException;
	
	public void init() throws IOException;
	
	public void delete(CarVO vo) throws IOException;
	
	public void endOpt() throws IOException;


}
