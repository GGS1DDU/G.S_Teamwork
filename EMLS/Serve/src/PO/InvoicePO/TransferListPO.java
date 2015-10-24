package InvoicePO;

import java.io.Serializable;

public class TransferListPO extends InvoicePO implements Serializable {
String time;
String id;
String transferID;
String arrival;
int seatNumber;
String surpervior;
String expressOrder;
double cost;
public TransferListPO(String t,String i,String td,String a,int s,
		String sr,String eo,double c){
	time=t;
	id=i;
	transferID=td;
	arrival=a;
	seatNumber=s;
	surpervior=sr;
	expressOrder=eo;
	cost=c;	
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
public String getArrival(){
	return arrival;
}
public String getSurpervior(){
	return surpervior;
}
public int getSeatNumber(){
	return seatNumber;
}
public double getCost(){
	return cost;
}
public String getExpressOrder(){
	return expressOrder;
}


}
