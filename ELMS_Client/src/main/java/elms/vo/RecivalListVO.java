package elms.vo;

public class RecivalListVO {
	String id;
	String time;
	String centerID;
	String orderID;
	String from;
	String state;
	public RecivalListVO(String i,String t,String ci,String o,String f,String s){
		this.orderID=o;
		this.centerID=ci;
		this.time=t;
		this.id=i;
		this.from=f;
		this.state=s;
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


}
