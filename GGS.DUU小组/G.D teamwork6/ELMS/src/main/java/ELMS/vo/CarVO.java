package ELMS.vo;

import java.io.Serializable;

public class CarVO extends MemberVO implements Serializable{
String id;
String plateNumber;
String usingTime;
String varChar;
public CarVO(String i,String pn,String ut,String v){
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
