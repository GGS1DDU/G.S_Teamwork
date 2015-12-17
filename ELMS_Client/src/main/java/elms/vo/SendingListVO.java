package elms.vo;

public class SendingListVO extends InvoiceVO{
	String courier;
	String time;
	String id;
	String orderID;
	String place;
	public SendingListVO(String i,String o,String u,String t,String p){
		this.id= i;
		this.courier =u;
		this.time =t;
		this.orderID=o;
		this.place=p;
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
	public String getPlace(){
		return place;
	}


}
