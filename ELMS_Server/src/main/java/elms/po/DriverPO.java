package elms.po;

import java.io.Serializable;

public class DriverPO implements Serializable{

	private static final long serialVersionUID = 2488517974998056691L;
	String id;
	String name;
	String birthday;
	String IDcard;
	String callNumber;
	String gender;
	String licenseDate;
//	String salary;
	public DriverPO(String i,String n,String b,String idc,String cn,String g,String ld
//			,String s
			){
		super();
		this.id=i;
		this.name=n;
		this.birthday=b;
		this.IDcard=idc;
		this.callNumber=cn;
		this.gender=g;
		this.licenseDate=ld;
//		this.salary=s;
	}
	public DriverPO() {
		// TODO 自动生成的构造函数存根
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
//	public String getSalary(){
//		return salary;
//	}
	public String getLicenseDate(){
		return licenseDate;
	}

}
