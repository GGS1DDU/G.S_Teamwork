package ELMS.po;
/**
 * 功能：系统账号
 * 作者 :郑闻昊
 */

import java.io.Serializable;

public class UserPO implements Serializable {


	String id;
	String name;
	String password;
	String job;
	
	public UserPO(String id,String n,String p,String job){
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
