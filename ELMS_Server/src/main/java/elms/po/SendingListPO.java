package elms.po;

import java.io.Serializable;

public class SendingListPO extends InvoicePO implements Serializable{

	private static final long serialVersionUID = -7351852415123070993L;
	String courier;//单据ID
	String time;//托运订单条形号码
	String id;//派送员
	String orderID;//到达日期
	String place;//所属营业厅
	String maker;
	String auditState;
	public SendingListPO(String i,String o,String u,String t,String p,String maker,String auditState){
		super();
		this.id= i;
		this.courier =u;
		this.time =t;
		this.orderID=o;
		this.place=p;
		this.maker=maker;
		this.auditState=auditState;
	}
	public SendingListPO() {
		// TODO 自动生成的构造函数存根
	}
	public String getID(){
		return id;
	}
	public String getOrderID(){
		return orderID;
	}
	public String getCourier(){
		return courier;
	}
	public String getTime(){
		return time;
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
