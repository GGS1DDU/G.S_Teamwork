package FinancePO;

import java.io.Serializable;

import UserPO.UserPO;

public class FinanceIncomePO implements Serializable{
String id;
String time;
double income;
String shop;
UserPO clerk;
public FinanceIncomePO(String i,String t,double ic,String s,UserPO c){
	id=i;
	time=t;
	income=ic;
	shop=s;
	clerk=c;	
}
public String getID(){
	return id;
}
public String getTime(){
	return time;
}
public double getIncome(){
	return income;
}
public String getShop(){
	return shop;
}
public UserPO getClerk(){
	return clerk;
}
}
