package ELMS.businesslogic.DealBL_stub;

import java.util.ArrayList;

import ELMS.businesslogicService.DealBlService;
import ELMS.vo.DealVO;
import ELMS.vo.RecordVO;

public class DealBL_stub implements DealBlService{
	
	
	
	public boolean BuildOrder(DealVO vo){
		
		return true;
	}
	
	
	
	public DealVO CourierInquiry(String orderID){
		return new DealVO(0, orderID, orderID, orderID, orderID, orderID, orderID, orderID, orderID, orderID, orderID, orderID, orderID, orderID, orderID, orderID, orderID, orderID, 0, 0, orderID, orderID, orderID, orderID);
	}
	
	
	public  DealVO recipients(String orderid,String realReciever, String time){
		
	}
		
	
	public ArrayList<RecordVO> Record(String time1, String time2,String courier_name);
	
	
	public void endDealOpt();

}
