package elms.businesslogic_service.dealblservice;

import java.util.ArrayList;

import elms.vo.DealVO;


public interface DealBlService {
				
	public boolean BuildOrder(DealVO vo);
	
	
	public DealVO CourierInquiry(String orderID);
	
	
	public  DealVO recipients(String orderid,String realReciever, String time);
	
	
	
	public  void endDealOpt();
		

	
}
