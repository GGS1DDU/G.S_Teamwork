package elms.vo;

public class ArrivalListVO {

	String id;
	String order;
	String time;
	String state;
	String from;
	public ArrivalListVO(String i,String o,String t,String s,String f){
		this.id=i;
		this.order=o;
		this.time=t;
		this.state=s;
		this.from=f;
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

}
