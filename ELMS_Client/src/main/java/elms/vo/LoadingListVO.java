package elms.vo;

import java.util.ArrayList;

public class LoadingListVO extends InvoiceVO{
	String id;//单据id
	String time;//装车日期
	String shopNumber;//本营业厅编号
	String transportNumber;//汽运编号
	String arrival;//到达地
	String carNumber;//车辆代号
	String surpervisor;//监装员
	String supercargo;//押运员
	String orderNumber;
//	ArrayList<String> orderNumber;
	double cost;//运费
	String place;

	public LoadingListVO(String id,String time,String shopNumber,String transportNumber,String arrival,String carNumber,
			String surpervisor,String supercargo,String orderNumber,double cost,String p){
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
