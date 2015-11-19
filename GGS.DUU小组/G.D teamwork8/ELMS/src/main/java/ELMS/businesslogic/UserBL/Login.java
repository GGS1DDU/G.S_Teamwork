package ELMS.businesslogic.UserBL;

public class Login {
	public int login (MockUserBL mbl,String id,String password){
		MockUser mu=mbl.findUser();
		if(mu.getPassword().equals(password)){
			if(mu.getJob().equals("系统管理员")){
				return 0;			
			}
			else if(mu.getJob().equals("快递员")){
				return 1;
			}
			
			return -1;
			
		}
		
		else{
			return -1;  //密码错误
		}
		
	}

}
