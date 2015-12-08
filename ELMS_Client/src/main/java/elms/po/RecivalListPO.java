package elms.po;

import java.io.Serializable;

public class RecivalListPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8105038715671597319L;
	String id;
	String time;
	String centerID;
	String orderID;
	String from;
	String state;
	public RecivalListPO(String i,String t,String ci,String o,String f,String s){
		super();
		this.id=i;
		this.centerID=ci;
		this.time=t;
		this.orderID=o;
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
