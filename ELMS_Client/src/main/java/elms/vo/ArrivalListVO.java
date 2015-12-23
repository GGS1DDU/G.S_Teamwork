package elms.vo;

public class ArrivalListVO extends InvoiceVO{

	String id;
	String order;
	String time;
	String state;
	String from;
	String place;
	public ArrivalListVO(String i,String o,String t,String s,String f,String p){
		this.id=i;
		this.order=o;
		this.time=t;
		this.state=s;
		this.from=f;
		this.place=p;
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

}