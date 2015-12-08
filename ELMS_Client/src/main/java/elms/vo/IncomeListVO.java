package elms.vo;

import java.util.ArrayList;

public class IncomeListVO {
	String id;
	double postage;
	String courier;
	String time;
	ArrayList<String> orderID;
	public IncomeListVO(String i,double pt,String c,String t,ArrayList<String> o){
		this.id=i;
		this.postage=pt;
		this.courier=c;
		this.time=t;
		this.orderID=o;
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
	public ArrayList<String> getOrderID(){
		return orderID;
	}



}
