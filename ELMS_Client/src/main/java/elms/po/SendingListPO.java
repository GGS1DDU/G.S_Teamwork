package elms.po;

import java.io.Serializable;

public class SendingListPO extends InvoicePO implements Serializable{
	private static final long serialVersionUID = -7351852415123070993L;
	String courier;
	String time;
	String id;
	String orderID;
	String place;
	public SendingListPO(String i,String o,String u,String t,String p){
		super();
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
