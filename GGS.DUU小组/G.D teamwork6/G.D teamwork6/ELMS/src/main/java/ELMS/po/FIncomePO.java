package ELMS.po;

import java.io.Serializable;



public class FIncomePO implements Serializable{
String id;
String time;
double income;
String shop;//Ӫҵ����Ϣ��
String clerk;
public FIncomePO(String i,String t,double ic,String s,String c){
	id=i;
	time=t;
	income=ic;
	shop=s;
	clerk=c;	
}
public String getID(){
	return id;
}

public void setID(String id){
	this.id = id;
}

public String getTime(){
	return time;
}

public void setTime(String time){
	this.time = time;
}

public double getIncome(){
	return income;
}

public void setIncome(double income){
	this.income = income;
}

public String getShop(){
	return shop;
}

public void setShop(String shop){
	this.shop = shop;
}

public String getClerk(){
	return clerk;
}

public void setClerk(String clerk){
	this.clerk = clerk;
}
}