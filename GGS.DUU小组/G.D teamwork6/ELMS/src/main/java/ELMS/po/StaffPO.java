package ELMS.po;

import java.io.Serializable;

public class StaffPO extends MemberPO implements Serializable{
String id;
String name;
String gender;
String post;
String IDcard;
double salary;
String callNumber;
public StaffPO(String i,String n,String g,String p,String idc,double s,String cn){
	id=i;
	name=n;
	gender=g;
	post=p;
	IDcard=idc;
	salary=s;
	callNumber=cn;
}
public String getID(){
	return id;
}
public String getName(){
	return name;
}
public String getGender(){
	return gender;
}
public String getPost(){
	return post;
}
public String getIDcard(){
	return IDcard;
}
public double getSalary(){
	return salary;
}
public String getCallNumber(){
	return callNumber;
}
}
