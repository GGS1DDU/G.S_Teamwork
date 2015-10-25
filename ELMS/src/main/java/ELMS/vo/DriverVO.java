package ELMS.vo;

import java.io.Serializable;

public class DriverVO extends MemberVO implements Serializable{

	String id;
	String name;
	String birthday;
	String IDcard;
	String callNumber;
	String gender;
	String licenseDate;
	String salary;
	public DriverVO(String i,String n,String b,String idc,String cn,String g,String ld,String s){
		id=i;
		name=n;
		birthday=b;
		IDcard=idc;
		callNumber=cn;
		gender=g;
		licenseDate=ld;
		salary=s;
	}
	public String getID(){
		return id;
	}
	public String getName(){
		return name;
	}
	public String getBirthday(){
		return birthday;
	}
	public String getIDcard(){
		return IDcard;
	}
	public String getCallNumber(){
		return callNumber;
	}
	public String getGender(){
		return gender;
	}
	public String getSalary(){
		return salary;
	}
	public String getLicenseDate(){
		return licenseDate;
	}
	}


