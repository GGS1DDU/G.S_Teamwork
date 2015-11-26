package elms.po;

import java.io.Serializable;

public class UserPO implements Serializable {


	/**
	 * 
	 */

	String id;
	String password;
	String name;
	String job;
	
	public UserPO(String id,String password,String name,String job){
		this.id=id;
		this.password=password;
		this.name=name;
		this.job=job;
	}	
	
	public UserPO() {
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

