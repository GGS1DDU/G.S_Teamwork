package elms.vo;

import java.util.ArrayList;

public class IncomeListVO extends InvoiceVO{
	String id;
	double postage;
	String courier;
	String time;
	String orderID;
//	ArrayList<String> orderID;
	String place;
	String maker;
	String auditState;
	public IncomeListVO(String i,double pt,String c,String t,String o,String p,String maker,String auditState){
		this.id=i;
		this.postage=pt;
		this.courier=c;
		this.time=t;
		this.orderID=o;
		this.place=p;
		this.maker=maker;
		this.auditState=auditState;
	}
	
	public String getID(){
		return id;
	}
	public String getTime(){
		return time;
	}
	public double getPostage(){
		return postage;
	}
	public String getCourier(){
		return courier;
	}
	public String getOrderID(){
		return orderID;
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
