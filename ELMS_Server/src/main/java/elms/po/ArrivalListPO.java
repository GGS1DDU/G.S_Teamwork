package elms.po;

import java.io.Serializable;

public class ArrivalListPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4995500667133253120L;


	String id;//单据ID
	String order;//中转单编号
	String time;//到达日期
	String state;//到达状态
	String from;//出发地
	
	public ArrivalListPO(String i,String o,String t,String s,String f){
		super();
		this.id=i;
		this.order=o;
		this.time=t;
		this.state=s;
		this.from=f;
	}
	
	public ArrivalListPO() {
		// TODO 自动生成的构造函数存根
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
