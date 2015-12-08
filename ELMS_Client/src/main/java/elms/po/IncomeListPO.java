package elms.po;

import java.io.Serializable;
import java.util.ArrayList;

public class IncomeListPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8942442903199947737L;
	String id;
	double postage;
	String courier;
	String time;
	ArrayList<String> orderID;
	public IncomeListPO(String i,double pt,String c,String t,ArrayList<String> o){
		super();
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
