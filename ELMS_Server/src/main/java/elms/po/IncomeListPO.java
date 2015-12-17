package elms.po;

import java.io.Serializable;
import java.util.ArrayList;

public class IncomeListPO implements Serializable{
	private static final long serialVersionUID = -4575042118755489013L;
	String id;//单据id
	double postage;//收费金额
	String courier;//快递员姓名
	String time;//收款日期
	String orderID;
//	ArrayList<String> orderID;//订单条形号码
	String place;
	public IncomeListPO(String i,double pt,String c,String t,String o,String p){
		super();
		this.id=i;
		this.postage=pt;
		this.courier=c;
		this.time=t;
		this.orderID=o;
		this.place=p;
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
	
	public String getOrderID(){
		return orderID;
	}
	public String getPlace(){
		return place;
	}

}
