package InvoicePO;

import java.io.Serializable;

public class ArrivalListPO extends InvoicePO implements Serializable{
	String id;
	String order;
	String time;
	String state;
	String from;
	public ArrivalListPO(String i,String o,String t,String s,String f){
		id=i;
		order=o;
		time=t;
		state=s;
		from=f;
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
