package elms.po;

import java.io.Serializable;
import java.util.ArrayList;

public class LoadingListPO extends InvoicePO implements Serializable{
	private static final long serialVersionUID = -1679107517967715487L;
	//YYT loadingList
	String id;//单据id
	String time;//装车日期
	String shopNumber;//本营业厅编号
	String transportNumber;//汽运编号
	String arrival;//到达地
	String carNumber;//车辆代号
	String surpervisor;//监装员
    String supercargo;//押运员
    String orderNumber;
    //	ArrayList<String> orderNumber;//订单条形号码
	double cost;//运费
	String place;//所属营业厅

	public LoadingListPO(String id,String time,String shopNumber,String transportNumber,String arrival,String carNumber,
			String surpervisor,String supercargo,String orderNumber,double cost,String p){
		super();
		this.id=id;
		this.time=time;
		this.shopNumber=shopNumber;
		this.transportNumber=transportNumber;
		this.arrival=arrival;
		this.carNumber=carNumber;
		this.surpervisor=surpervisor;
		this.supercargo=supercargo;
		this.orderNumber=orderNumber;
		this.cost=cost;	
		this.place=p;
	}
	public LoadingListPO() {
		// TODO 自动生成的构造函数存根
	}
	public String getID(){
		return id;
	}
	public String getTime(){
		return time;
	}
	public String getShopNumber(){
		return shopNumber;
	}
	public String getTransportNumber(){
		return transportNumber;
	}
	public String getArrival(){
		return arrival;
	}
	public String getCarNumber(){
		return carNumber;
	}
	public String getSurpervior(){
		return surpervisor;
	}
	public String getSupercargo(){
		return supercargo;
	}
	public String getOrderNumber(){
		return orderNumber;
	}
	public double getCost(){
		return cost;
	}
	public String getPlace(){
		return place;
	}
}
