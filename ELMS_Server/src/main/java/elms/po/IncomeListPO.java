package elms.po;

import java.io.Serializable;
import java.util.ArrayList;

public class IncomeListPO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8942442903199947737L;
	String id;//单据id
	double postage;//收费金额
	String courier;//快递员姓名
	String time;//收款日期
	ArrayList<String> orderID;//订单条形号码
	public IncomeListPO(String i,double pt,String c,String t,ArrayList<String> o){
		super();
		this.id=i;
		this.postage=pt;
		this.courier=c;
		this.time=t;
		this.orderID=o;
	}
	public IncomeListPO() {
		// TODO 自动生成的构造函数存根
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
