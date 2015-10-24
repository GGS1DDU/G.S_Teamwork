package InvoicePO;

import java.io.Serializable;

import UserPO.UserPO;

public class IncomeListPO extends InvoicePO implements Serializable{
String id;
String order;
double postage;
UserPO courier;
String time;
public IncomeListPO(String i,String o,double pt,UserPO c,String t){
	id=i;
	order=o;
	postage=pt;
	courier=c;
	time=t;
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
public double getPostage(){
	return postage;
}
public UserPO getCourier(){
	return courier;
}
}
