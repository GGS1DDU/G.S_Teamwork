package ELMS.vo;
/**
 * 功能：接单记录
 * @author ZWH
 *
 */

public class RecordVO {
	long OrderID;
	String dealTime; 
	String courier_name; 
	double fee;
	
	
	public RecordVO(long orderID, String dealTime, String courier_name,
			double fee) {
		super();
		OrderID = orderID;
		this.dealTime = dealTime;
		this.courier_name = courier_name;
		this.fee = fee;
	}


	public long getOrderID() {
		return OrderID;
	}


	public String getDealTime() {
		return dealTime;
	}


	public String getCourier_name() {
		return courier_name;
	}


	public double getFee() {
		return fee;
	}
	
}
