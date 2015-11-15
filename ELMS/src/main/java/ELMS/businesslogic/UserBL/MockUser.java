package ELMS.businesslogic.UserBL;

public class MockUser {
	
	

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
