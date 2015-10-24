package ELMS.businesslogicService;


import ELMS.vo.UserVO;

public interface UserBlService {
	public UserVO login(String id, String password);
	
	
	public UserVO updateJob(String id ,String job);
	
	
	public boolean addUser(String id, String password, String name,String job);
	
	
	public boolean deleteUser(String id);
	
	
	public UserVO inquiryUser(String id);
	
	
	public void endAccountOpt();
	

}
