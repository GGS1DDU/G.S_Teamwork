package elms.po;

import java.io.Serializable;

public class RecivalListPO extends InvoicePO implements Serializable{
	private static final long serialVersionUID = 788430721492741089L;
	String id;//单据ID
	String time;//装车日期
	String centerID;//中转中心编号
	String orderID;//中转单编号
	String from;//出发地
	String state;//货物到达状态
	String place;//所属中转中心
	public RecivalListPO(String i,String t,String ci,String o,String f,String s,String p){
		super();
		this.id=i;
		this.centerID=ci;
		this.time=t;
		this.orderID=o;
		this.from=f;
		this.state=s;
		this.place=p;
	}
	public RecivalListPO() {
		// TODO 自动生成的构造函数存根
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
	public String getPlace(){
		return place;
	}

}
