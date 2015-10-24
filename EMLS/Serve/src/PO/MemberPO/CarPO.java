package MemberPO;

import java.io.Serializable;

public class CarPO implements Serializable{
String id;
String plateNumber;
String usingTime;
String varChar;
public CarPO(String i,String pn,String ut,String v){
	id=i;
	plateNumber=pn;
	usingTime=ut;
	varChar=v;
}
public String getID(){
	return id;
}
public String getPlateNumber(){
	return plateNumber;
}
public String getUsingTime(){
	return usingTime;
}
public String getVarChar(){
	return varChar;
}
}
