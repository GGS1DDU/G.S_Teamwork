package elms.vo;
/**
 * 
 * @author ZWH
 *
 */
public class UserVO  {


	String id;
	String password;
	String name;
	String job;
	/**
	 * 构造函数
	 * @param id
	 * @param password
	 * @param name
	 * @param job
	 */
	public UserVO(String id,String password,String name,String job){
		this.id=id;
		this.password=password;
		this.name=name;
		this.job=job;
	}	
	
	public UserVO() {
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