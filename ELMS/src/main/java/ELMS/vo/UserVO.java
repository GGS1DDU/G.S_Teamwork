package ELMS.vo;

/**
 * 功能：系统账号
 * 作者 :郑闻昊
 */


public class UserVO  {


	String id;
	String name;
	String password;
	String job;
	
	public UserVO(String id,String n,String p,String job){
		this.id=id;
		this.name=n;
		this.password=p;
		this.job=job;
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