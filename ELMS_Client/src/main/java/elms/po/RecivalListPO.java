package elms.po;

import java.io.Serializable;

public class RecivalListPO extends InvoicePO implements Serializable{
	private static final long serialVersionUID = 788430721492741089L;
	String id;
	String time;
	String centerID;
	String orderID;
	String from;
	String state;
	String place;
	public RecivalListPO(String i,String t,String ci,String o,String f,String s,String p){
		super();
		this.id=i;
		this.centerID=ci;
		this.time=t;
		this.orderID=o;
		this.from=f;
		this.state=s;
		this.place=p;
	}
	public String getCenterID(){
		return centerID;
	}
	public String getTime(){
		return time;
	}
	public String getID(){
		return id;
	}
	public String getOrderID(){
		return orderID;
	}
	public String getFrom(){
		return from;
	}
	public String getState(){
		return state;
	}
	public String getPlace(){
		return place;
	}

}
