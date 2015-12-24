package elms.vo;

public class SendingListVO extends InvoiceVO{
	String courier;
	String time;
	String id;
	String orderID;
	String place;
	String maker;
	String auditState;
	public SendingListVO(String i,String o,String u,String t,String p,String maker,String auditState){
		this.id= i;
		this.courier =u;
		this.time =t;
		this.orderID=o;
		this.place=p;
		this.maker=maker;
		this.auditState=auditState;
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


	public String getMaker(){
		return maker;
	}
	
	public String getAuditState(){
		return auditState;
	}
}
