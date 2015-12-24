package elms.vo;

public class ArrivalListVO extends InvoiceVO{

	String id;
	String order;
	String time;
	String state;
	String from;
	String place;
	String maker;
	String auditState;
	public ArrivalListVO(String i,String o,String t,String s,String f,String p,String maker,String auditState){
		this.id=i;
		this.order=o;
		this.time=t;
		this.state=s;
		this.from=f;
		this.place=p;
		this.maker=maker;
		this.auditState=auditState;
	}
	public String getID(){
		return id;
	}
	public String getOrder(){
		return order;
	}
	public String getTime(){
		return time;
	}
	public String getState(){
		return state;
	}
	public String getFrom(){
		return from;
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
