package ELMS.vo;

import java.io.Serializable;

import ELMS.businesslogic.InvoiceBL.State;
import ELMS.vo.InvoiceVO;

public class RecivalListVO extends InvoiceVO implements Serializable {
	String centerID;
	String time;
	String id;
	String from;
	Enum<State> state;
	//xiugai state ,yuanlaishi String now ENUM
	//don,t know why zht write "String id" before "String ci"
	public RecivalListVO(String ci,String t,String i,String f,Enum<State> state){
		this.centerID=ci;
		this.time=t;
		this.id=i;
		this.from=f;
		this.state=state;
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
	public Enum<State> getState(){
		return state;
	}
}
