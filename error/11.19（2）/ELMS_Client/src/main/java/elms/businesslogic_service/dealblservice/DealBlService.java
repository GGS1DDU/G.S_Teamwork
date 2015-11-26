package elms.businesslogic_service.dealblservice;

import java.io.IOException;
import java.util.ArrayList;

import elms.vo.DealVO;


public interface DealBlService {
				
	public boolean BuildOrder(DealVO vo) throws IOException;
	
	
	public DealVO FindOrder(String orderID) throws IOException;
	
	public ArrayList<DealVO> FindAllOrder() throws IOException;
	
	 
	
	
	public  DealVO recipients(String orderid,String realReciever, String time) throws IOException;
	
	public boolean updataTrack(String orderID,String newTrack)  throws IOException;
	
	
	
	public  void endDealOpt();
		

	
}
