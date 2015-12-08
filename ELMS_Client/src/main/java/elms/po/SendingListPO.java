package elms.po;

import java.io.Serializable;

public class SendingListPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 9130639063981787683L;
	String courier;
	String time;
	String id;
	String orderID;
	public SendingListPO(String i,String o,String u,String t){
		super();
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
