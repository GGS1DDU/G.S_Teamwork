package elms.po;

import java.io.Serializable;

public class RecivalListPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8105038715671597319L;
	String id;//单据ID
	String time;//装车日期
	String centerID;//中转中心编号
	String orderID;//中转单编号
	String from;//出发地
	String state;//货物到达状态
	public RecivalListPO(String i,String t,String ci,String o,String f,String s){
		super();
		this.id=i;
		this.centerID=ci;
		this.time=t;
		this.orderID=o;
		this.from=f;
		this.state=s;
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

}
