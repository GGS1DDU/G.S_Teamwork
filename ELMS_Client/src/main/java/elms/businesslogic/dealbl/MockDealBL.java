package elms.businesslogic.dealbl;

import elms.vo.DealVO;

public class MockDealBL extends DealBL{
		DealVO order;
		public MockDealBL(DealVO order){
			this.order=order;
		}
		public DealVO CourierInquiry(){
			return order;
			
		}
}
