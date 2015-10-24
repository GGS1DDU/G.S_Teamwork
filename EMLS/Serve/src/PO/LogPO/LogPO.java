package LogPO;

import java.io.Serializable;

import UserPO.UserPO;

public class LogPO implements Serializable{
String id;
String category;
String time;
UserPO operator;
public LogPO(String i,String c,String t,UserPO o){
	id=i;
	category=c;
	time=t;
	operator=o;
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
public UserPO getOperator(){
	return operator;
}
}
