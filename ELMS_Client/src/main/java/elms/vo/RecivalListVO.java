package elms.vo;

public class RecivalListVO extends InvoiceVO{
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
	public RecivalListVO(String i,String did,String t,String ci,String o,String f,String s,String p,String maker,String auditState){
		this.dealOrderID=did;
		this.orderID=o;	
		this.centerID=ci;
		this.time=t;
		this.id=i;
		this.from=f;
		this.state=s;
		this.place=p;
		this.maker=maker;
		this.auditState=auditState;
	}
	public RecivalListVO() {
		// TODO Auto-generated constructor stub
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
