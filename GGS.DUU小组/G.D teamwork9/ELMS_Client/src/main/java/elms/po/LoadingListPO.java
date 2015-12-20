package elms.po;

import java.io.Serializable;
import java.util.ArrayList;

public class LoadingListPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4860237118376678854L;
	String id;//单据id
	String time;//装车日期
	String shopNumber;//本营业厅编号
	String transportNumber;//汽运编号
	String arrival;//到达地
	String carNumber;//车辆代号
	String surpervisor;//监装员
	String supercargo;//押运员
	ArrayList<String> orderNumber;
	double cost;//运费
	

	public LoadingListPO(String id,String time,String shopNumber,String transportNumber,String arrival,String carNumber,
			String surpervisor,String supercargo,ArrayList<String> orderNumber,double cost){
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
	public ArrayList<String> getOrderNumber(){
		return orderNumber;
	}
	public double getCost(){
		return cost;
	}
}
