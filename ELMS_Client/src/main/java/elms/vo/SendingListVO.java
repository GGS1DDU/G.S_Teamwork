package elms.vo;

public class SendingListVO {
	String courier;
	String time;
	String id;
	String orderID;
	public SendingListVO(String i,String o,String u,String t){
		this.id= i;
		this.courier =u;
		this.time =t;
		this.orderID=o;
	}
	public String getID(){
		return id;
	}
	public String getOrderID(){
		return orderID;
	}
	public String getCourier(){
		return courier;
	}
	public String getTime(){
		return time;
	}


}
