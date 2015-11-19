package ELMS.businesslogic.DealBL;

public class MockDealBL {
	MockDeal order;
	public MockDealBL(MockDeal order){
		this.order=order;
	}
	public MockDeal CourierInquiry(){
		return order;
		
	}

}
