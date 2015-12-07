package elms.po;

import java.io.Serializable;
import java.util.ArrayList;

public class TransferListPO implements Serializable{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7638074861344375260L;
	String id;//单据ID
	String time;//装车日期	
	String transferID;//中转单编号
	String transportNum;//航班号/车次号
	String departure;//出发地
	String arrival;//到达地
	String seatNumber;//货柜号
	String surpervior;//监装员
	ArrayList<String> orderID;//托运订单
	double cost;//运费
	public TransferListPO(String i,String t,String td,String tn,String d,String a,String s,
			String sr,ArrayList<String> o,double c){
		super();
		this.id=i;
		this.time=t;		
		this.transferID=td;
		this.transportNum=tn;
		this.departure=d;
		this.arrival=a;
		this.seatNumber=s;
		this.surpervior=sr;
		this.orderID=o;
		this.cost=c;	
	}
	public TransferListPO() {
		// TODO 自动生成的构造函数存根
	}
	public String getID(){
		return id;
	}
	public String getTime(){
		return time;
	}
	public String getTransferID(){
		return transferID;
	}
	public String getTransportNum(){
		return transportNum;
	}
	public String getDeparture(){
		return departure;
	}
	public String getArrival(){
		return arrival;
	}
	public String getSeatNumber(){
		return seatNumber;
	}
	public String getSurpervior(){
		return surpervior;
	}
	public ArrayList<String> getOrderID(){
		return orderID;
	}
	public double getCost(){
		return cost;
	}

}