package ELMS.businesslogic.UserBL;

import ELMS.vo.UserVO;

public class MockUser extends UserVO {
	
	String id=" ";
	String name=" ";
	String password=" ";
	String job=" ";
	
	public MockUser(String id,String n,String p,String job){
		this.id=id;
		this.name=n;
		this.password=p;
		this.job=job;
	}	
	
	public MockUser() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public String getJob() {
		return job;
	}


}
