package elms.po;

import java.io.Serializable;

public class ArrivalListPO extends InvoicePO implements Serializable{

	private static final long serialVersionUID = -5359128593976757996L;
	String id;//单据ID
	String order;//中转单编号
	String time;//到达日期
	String state;//到达状态
	String from;//出发地
	String place;//所属营业厅
	String maker;
	String auditState;
	public ArrivalListPO(String i,String o,String t,String s,String f,String p,String maker,String auditState){
		super();
		this.id=i;
		this.order=o;
		this.time=t;
		this.state=s;
		this.from=f;
		this.place=p;
		this.maker=maker;
		this.auditState=auditState;
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
    public String getPlace(){
    	return place;
    }
    public String getMaker(){
		return maker;
	}
	
	public String getAuditState(){
		return auditState;
	}

}
