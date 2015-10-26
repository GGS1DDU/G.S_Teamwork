package ELMS.vo;

import java.io.Serializable;

import ELMS.vo.InvoiceVO;

public class RecivalListVO extends InvoiceVO implements Serializable {
	String centerID;
	String time;
	String id;
	String from;
	String state;
	public RecivalListVO(String id,String ci,String t,String i,String f,String s){
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
