package FinancePO;

import java.io.Serializable;

import UserPO.UserPO;

public class FinanceExpensePO implements Serializable{
String id;
String category;
String time;
double expense;
UserPO assistant;
UserPO clerk;
public FinanceExpensePO(String i,String ct,String t,double e,UserPO a,UserPO c){
	id=i;
	category=ct;
	time=t;
	expense=e;
	assistant=a;
	clerk=c;
}
public String getID(){
	return id;
}
public String getCategory(){
	return category;
}
public String getTime(){
	return time;
}
public double getExpense(){
	return expense;
}
public UserPO getAssistant(){
	return assistant;
}
public UserPO getClerk(){
	return clerk;
}
}