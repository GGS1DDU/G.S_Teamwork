package businesslogic.DealBL;

import static org.junit.Assert.*;

import org.junit.Test;

import ELMS.businesslogic.DealBL.MockDealBL;
import ELMS.vo.DealVO;

public class CourierInquiry_tester {

	@Test
	public void testCourierInquiry(){
		MockDealBL dealbl=new MockDealBL(new DealVO("0000000001","快递员A","鼓楼营业厅","2015/10/24","寄件人A","南京","南京大学","110","收件人A","广州","中山大学","119","书",1,1.1,1.1,"标准快递","纸箱",1,3,
				"收件人B","2015/10/27","从鼓楼营业厅出发，到达南京中转中心，从南京中转中心出发，到达中山中转中心，从中山中转中心出发，到达中山市营业厅","已送达"));
		
		
		
		assertEquals("0000000001",dealbl.CourierInquiry().getOrderID());
		assertEquals("快递员A",dealbl.CourierInquiry().getCourier_name());
		assertEquals("寄件人A",dealbl.CourierInquiry().getSender_name());
	}
}
