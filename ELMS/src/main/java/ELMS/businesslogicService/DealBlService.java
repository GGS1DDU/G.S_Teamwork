package ELMS.businesslogicService;

import java.util.ArrayList;

import ELMS.vo.DealVO;
import ELMS.vo.RecordVO;


public interface DealBlService {
			
	
	
	public boolean BuildOrder(DealVO vo);
	
	
	public DealVO CourierInquiry(String orderID);
	
	
	public  DealVO recipients(String orderid,String realReciever, String time);
	
	
	public ArrayList<RecordVO> Record(String time1, String time2,String courier_name);
	
	
	public void endDealOpt();
	
}
