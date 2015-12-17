package elms.po;

import java.io.Serializable;
import java.util.ArrayList;

public class TransferListPO extends InvoicePO implements Serializable{
	private static final long serialVersionUID = -540971783403062619L;
	String id;
	String time;	
	String transferID;
	String transportNum;
	String departure;
	String arrival;
	String seatNumber;
	String surpervior;
	String orderID;
//	ArrayList<String> orderID;
	double cost;
	String place;
	public TransferListPO(String i,String t,String td,String tn,String d,String a,String s,
			String sr,String o,double c,String p){
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
		this.place=p;
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
	public String getOrderID(){
		return orderID;
	}
	public double getCost(){
		return cost;
	}
	public String getPlace(){
		return place;
	}

}
