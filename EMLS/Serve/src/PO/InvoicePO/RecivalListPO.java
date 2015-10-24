package InvoicePO;

import java.io.Serializable;

public class RecivalListPO extends InvoicePO implements Serializable {
	String centerID;
	String time;
	String id;
	String from;
	String state;
	public RecivalListPO(String ci,String t,String i,String f,String s){
		centerID=ci;
		time=t;
		id=i;
		from=f;
		state=s;
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
	public String getFrom(){
		return from;
	}
	public String getState(){
		return state;
	}
}
