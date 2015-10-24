package InvoicePO;

import java.io.Serializable;

public class LoadingListPO extends InvoicePO implements Serializable {
String id;
String order;
String time;
String shopNumber;
String carNumber;
String arrival;
String surpervior;
String supercargo;
double cost;
String expressMethod;

public LoadingListPO(String i,String o,String t,String sn,String cn,
		              String a,String sr,String so,
		              double c,String em){
	id=i;
	order=o;
	time=t;
	shopNumber=sn;
	carNumber=cn;
	arrival=a;
	surpervior=sr;
	supercargo=so;
	cost=c;
	expressMethod=em;
	
}
public String getID(){
	return id;
}
public String getOrder(){
	return order;
}
public String getTime(){
	return time;
}
public String getShopNumber(){
	return shopNumber;
}
public String getCarNumber(){
	return carNumber;
}
public String getArrival(){
	return arrival;
}
public String getSurpervior(){
	return surpervior;
}
public String getSupercargo(){
	return supercargo;
}
public double getCost(){
	return cost;
}
public String getExpressMethod(){
	return expressMethod;
}
}
