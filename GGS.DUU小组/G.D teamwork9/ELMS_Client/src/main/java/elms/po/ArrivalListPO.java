package elms.po;

import java.io.Serializable;

public class ArrivalListPO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4995500667133253120L;
	String id;
	String order;
	String time;
	String state;
	String from;
	public ArrivalListPO(String i,String o,String t,String s,String f){
		super();
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
