package ELMS.businesslogic.StorageBL;

import ELMS.vo.DealVO;

public class MockDeal extends DealVO {

	public MockDeal(String orderID, String courier_name, String hall,
			String dealTime, String sender_name, String sender_city,
			String sender_company, String sender_phonenumber,
			String receiver_name, String receiver_city,
			String receiver_company, String receiver_phonenumber,
			String goods_name, int goods_amount, double goods_weight,
			double goods_volume, String type, String pack, double fee,
			int delaydays, String actualreceiver_name, String receivaltime,
			String track, String state) {
		super(orderID, courier_name, hall, dealTime, sender_name, sender_city,
				sender_company, sender_phonenumber, receiver_name, receiver_city,
				receiver_company, receiver_phonenumber, goods_name, goods_amount,
				goods_weight, goods_volume, type, pack, fee, delaydays,
				actualreceiver_name, receivaltime, track, state);
		// TODO Auto-generated constructor stub
	}

}
