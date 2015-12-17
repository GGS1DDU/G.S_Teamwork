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
	public IncomeListVO(String i,double pt,String c,String t,String o,String p){
		this.id=i;
		this.postage=pt;
		this.courier=c;
		this.time=t;
		this.orderID=o;
		this.place=p;
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


}
