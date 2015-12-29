package elms.po;

import java.io.Serializable;

public class RecivalListPO extends InvoicePO implements Serializable{
	private static final long serialVersionUID = 788430721492741089L;
	String id;
	String dealOrderID;
	String time;
	String centerID;
	String orderID;
	String from;
	String state;
	String place;
	String maker;
	String auditState;
	public RecivalListPO(String i,String did,String t,String ci,String o,String f,String s,String p,String maker,String auditState){
		super();
		this.id=i;
		this.dealOrderID=did;
		this.centerID=ci;
		this.time=t;
		this.orderID=o;
		this.from=f;
		this.state=s;
		this.place=p;
		this.maker=maker;
		this.auditState=auditState;
	}
	public String getCenterID(){
		return centerID;
	}
	public String getdealOrderID(){
		return dealOrderID;
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
	public String getMaker(){
		return maker;
	}
	
	public String getAuditState(){
		return auditState;
	}
}
